package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.entity.UserEntity;
import rest.service.RestService;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private RestService<UserEntity> userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<UserEntity> userEntities = userService.getAll(UserEntity.class);
        return new ResponseEntity(userEntities, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UserEntity userEntity) {
        UserEntity createdUserEntity = userService.create(userEntity);
        return new ResponseEntity(createdUserEntity, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody UserEntity userEntity) {
        UserEntity createdUserEntity = userService.update(userEntity);
        return new ResponseEntity(createdUserEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public ResponseEntity getById() {
        UserEntity createdUserEntity = userService.getById(UserEntity.class, "1");
        return new ResponseEntity(createdUserEntity, HttpStatus.OK);
    }
}
