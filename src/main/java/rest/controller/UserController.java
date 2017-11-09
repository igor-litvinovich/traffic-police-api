package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.UserEntity;
import rest.service.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<UserEntity> userEntities = userService.getAll(UserEntity.class);
        Map map = new HashMap();
        map.put("data", userEntities);
        return new ResponseEntity(map, HttpStatus.OK);
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) {
        UserEntity createdUserEntity = userService.getById(UserEntity.class, id);
        return new ResponseEntity(createdUserEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity auth(@RequestBody() UserEntity userEntity, HttpServletResponse response) throws Exception {
        UserEntity user = userService.authenticate(userEntity);
        response.addCookie(new Cookie("roleName", user.getRole()));
        return ResponseEntity.ok().build();
    }
}
