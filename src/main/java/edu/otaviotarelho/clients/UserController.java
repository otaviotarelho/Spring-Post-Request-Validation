package edu.otaviotarelho.clients;

import edu.otaviotarelho.model.UserModel;
import edu.otaviotarelho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

   @RequestMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
   public ResponseEntity<String> user(@RequestBody UserModel userModel){
        return ResponseEntity.ok(userService.save(userModel));
   }

}
