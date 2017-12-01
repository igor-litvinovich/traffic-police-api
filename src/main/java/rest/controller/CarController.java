package rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.CarEntity;
import rest.request.RequestParams;

@RestController
@RequestMapping(value = "api/cars")
public class CarController extends BaseController<CarEntity> {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams) {
        return super.getAll(requestParams, CarEntity.class);
    }

}
