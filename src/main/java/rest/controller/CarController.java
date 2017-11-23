package rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.CarEntity;

@RestController
@RequestMapping(value = "api/cars")
public class CarController extends BaseController<CarEntity> {
}
