package rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.FirmsEntity;
import rest.request.RequestParams;

@RestController
@RequestMapping(value = "api/firms")
public class FirmController extends BaseController<FirmsEntity> {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams) {
        return super.getAll(requestParams, FirmsEntity.class);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    ResponseEntity delete(@RequestParam("id") String id) {
        return super.delete(FirmsEntity.class, id);
    }
}
