package rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.CarEntity;
import rest.request.RequestParams;

@RestController
@RequestMapping(value = "api/cars")
public class CarController extends BaseController<CarEntity> {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams) {
        return super.getAll(requestParams, CarEntity.class);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    ResponseEntity delete(@RequestParam("id") String id) {
        return super.delete(CarEntity.class, id);
    }
}
