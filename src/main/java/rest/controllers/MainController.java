package rest.controllers;

import rest.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public ResponseEntity index() {
        return new ResponseEntity("qwewew", HttpStatus.OK);
    }
}
