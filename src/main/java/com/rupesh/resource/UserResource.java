package com.rupesh.resource;

import com.rupesh.model.UserDTO;
import com.rupesh.pagination.PagingRequest;
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

    /**
     *
     * @param userDTO
     * @return
     */
    @PostMapping(path={"/register"})
    public ResponseEntity<?> saveUser(@RequestBody final UserDTO userDTO){
        return new ResponseEntity(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    /**
     *
     * @param pagingRequest
     * @return
     */
    @PostMapping(path={"/all"})
    public ResponseEntity<?> allUsers(@RequestBody final PagingRequest pagingRequest){
        return new ResponseEntity(userService.getAllUser(pagingRequest), HttpStatus.OK);
    }

    @PutMapping("/assign-role/id/{userId}/role/{roleName}")
    public ResponseEntity<?> assignRole(@PathVariable final Long userId,
                                        @PathVariable final String roleName){
        return new ResponseEntity(userService.assignRole(roleName,userId), HttpStatus.CREATED);
    }

    @PutMapping("/remove-role/id/{userId}/role/{roleName}")
    public ResponseEntity<?> removeAssignedRole(@PathVariable final Long userId,
                                                @PathVariable final String roleName){
        return new ResponseEntity(userService.removeAssignedRole(roleName,userId), HttpStatus.CREATED);
    }
}
