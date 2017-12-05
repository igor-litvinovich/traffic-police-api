package rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.CountriesEntity;
import rest.request.RequestParams;

@RestController
@RequestMapping(value = "api/countries")
public class CountryController extends BaseController<CountriesEntity> {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams) {
        return super.getAll(requestParams, CountriesEntity.class);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    ResponseEntity delete(@RequestParam("id") String id) {
        return super.delete(CountriesEntity.class, id);
    }
}
