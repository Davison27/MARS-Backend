package com.david.citasMedicas.Controller;

import com.david.citasMedicas.DTO.UserDTO;
import com.david.citasMedicas.exception.Exceptions;
import com.david.citasMedicas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){ this.userService=userService; }

    @GetMapping(path = "/users/{id}")
    public UserDTO one(@PathVariable String id) { return userService.findOne(id); }

    @GetMapping(path = "/users")
    public List<UserDTO> all(){ return userService.findAll(); }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        userService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
