package rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.CountriesEntity;
import rest.request.RequestParams;

@RestController
@RequestMapping(value = "api/countries")
public class CountryController extends BaseController<CountriesEntity> {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams) {
        return super.getAll(requestParams, CountriesEntity.class);
    }

}
