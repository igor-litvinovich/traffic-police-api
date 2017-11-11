package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rest.request.RequestParams;
import rest.service.RestService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController<T> implements Controller<T> {

    @Autowired
    private RestService<T> service;

    @Override
    public ResponseEntity getAll(RequestParams requestParams) {
        List<T> userEntities = service.filterEntities(requestParams);
        Map result = new HashMap();
        result.put("data", userEntities);
        result.put("recordsTotal", userEntities.size());
        result.put("recordsFiltered", userEntities.size());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity create(T entity) {
        T createdEntity = service.create(entity);
        return new ResponseEntity(createdEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity update(T entity) {
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
