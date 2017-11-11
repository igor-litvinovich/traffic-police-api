package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.UserEntity;
import rest.request.RequestParams;
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
    public ResponseEntity getAll(@ModelAttribute() RequestParams requestParams) {
        List<UserEntity> userEntities = userService.filterEntities(requestParams);
        Map result = new HashMap();
        result.put("data", userEntities);
        result.put("recordsTotal", userEntities.size());
        result.put("recordsFiltered", userEntities.size());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UserEntity userEntity) {
        UserEntity createdUserEntity = userService.create(userEntity);
        return new ResponseEntity(createdUserEntity, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody() UserEntity userEntity) {
        UserEntity updatedUserEntity = userService.update(userEntity);
        Map result = new HashMap();
        result.put("data", updatedUserEntity);
        return new ResponseEntity(result, HttpStatus.OK);
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
