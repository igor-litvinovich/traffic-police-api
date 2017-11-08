package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.Services.RestService;
import rest.models.User;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private RestService<User> userService;

    @RequestMapping("/")
    public ResponseEntity index() {
        List<User> users = userService.getAll(User.class);
        return new ResponseEntity(users, HttpStatus.OK);
    }
}
