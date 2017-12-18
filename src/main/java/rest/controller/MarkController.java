package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.FirmsEntity;
import rest.entity.MarksEntity;
import rest.request.RequestParams;
import rest.service.MarkServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/marks")
public class MarkController extends BaseController<MarksEntity> {

    @Autowired
    private MarkServiceImpl service;

    @Override
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams, Class<MarksEntity> tClass) {
        List<MarksEntity> entities = service.filterEntities(requestParams, MarksEntity.class);
        Map result = new HashMap();
        Map resultEntities = new HashMap();
        resultEntities.put("id", entities.get(0).getId());
        resultEntities.put("markName", entities.get(0).getMarkName());
        List<Map> list = new ArrayList();
        list.add(resultEntities);
        result.put("data", list);
        result.put("recordsTotal", entities.size());
        result.put("recordsFiltered", entities.size());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    ResponseEntity delete(@RequestParam("id") String id) {
        return super.delete(MarksEntity.class, id);
    }
}
