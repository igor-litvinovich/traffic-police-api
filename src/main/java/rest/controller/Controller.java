package rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.request.RequestParams;

public interface Controller<T> {

    @RequestMapping(value = "", method = RequestMethod.GET)
    ResponseEntity getAll(@ModelAttribute() RequestParams requestParams, Class<T> tClass);

    @RequestMapping(value = "", method = RequestMethod.POST)
    ResponseEntity create(@RequestBody T entity);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    ResponseEntity update(@RequestBody T entity);

    ResponseEntity getById(Class<T> clazz, @PathVariable("id") String id);

    ResponseEntity delete(Class<T> clazz, @RequestParam("id") String id);
}
