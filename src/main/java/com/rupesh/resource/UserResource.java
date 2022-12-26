package com.rupesh.resource;

import com.rupesh.model.UserDTO;
import com.rupesh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path={"/users"})
public class UserResource {

    private final IUserService userService;

    @Autowired
    public UserResource(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(path={"/register"})
    public ResponseEntity<?> saveUser(@RequestBody final UserDTO userDTO){
        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping(path={"/filter/{userId}"})
    public ResponseEntity<?> filterUser(@PathVariable final Long userId){
        return new ResponseEntity<>(userService.getAllUser(userId), HttpStatus.OK);
    }

    @GetMapping(path={"/all"})
    public ResponseEntity<?> allUsers(){
        return new ResponseEntity<>(userService.getAllUser(null), HttpStatus.OK);
    }

}
