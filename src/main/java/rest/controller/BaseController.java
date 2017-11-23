package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import rest.request.RequestParams;
import rest.service.RestService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class BaseController<T> implements Controller<T> {

    @Autowired
    private RestService<T> service;

    @Override
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams) {
        List entities = service.filterEntities(requestParams);
        Map result = new HashMap();
        result.put("data", entities);
        result.put("recordsTotal", entities.size());
        result.put("recordsFiltered", entities.size());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity create(@RequestBody T entity) {
        T createdEntity = service.create(entity);
        return new ResponseEntity(createdEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity update(@RequestBody T entity) {
        T updatedUserEntity = service.update(entity);
        Map result = new HashMap();
        result.put("data", updatedUserEntity);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getById(Class<T> clazz, String id) {
        T entity = service.getById(clazz, id);
        return new ResponseEntity(entity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(Class<T> clazz, String id) {
        T deletedUser = service.delete(clazz, id);
        return new ResponseEntity(deletedUser, HttpStatus.OK);
    }
}
