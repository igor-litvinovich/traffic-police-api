package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.UserEntity;
import rest.service.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value = "api/users")
public class UserController extends BaseController<UserEntity> {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) {
        return super.getById(UserEntity.class, id);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam("id") String id) {
       return super.delete(UserEntity.class, id);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity auth(HttpServletResponse response, @RequestBody() UserEntity userEntity) throws Exception {
        UserEntity user = userService.authenticate(userEntity);
        response.addCookie(new Cookie("userRole", user.getRole()));
        response.sendRedirect("/panel.html");
        return ResponseEntity.ok().build();
    }
}
