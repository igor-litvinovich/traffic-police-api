package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.FirmsEntity;
import rest.entity.JackedCarsEntity;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams) {
        return super.getAll(requestParams, MarksEntity.class);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    ResponseEntity delete(@RequestParam("id") String id) {
        return super.delete(MarksEntity.class, id);
    }
}
