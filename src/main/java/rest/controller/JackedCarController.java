package rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.FirmsEntity;
import rest.entity.JackedCarsEntity;
import rest.request.RequestParams;

@RestController
@RequestMapping(value = "api/jacked")
public class JackedCarController extends BaseController<JackedCarsEntity> {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams) {
        return super.getAll(requestParams, JackedCarsEntity.class);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    ResponseEntity delete(@RequestParam("id") String id) {
        return super.delete(JackedCarsEntity.class, id);
    }
}
