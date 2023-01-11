package com.rupesh.resource;

import com.rupesh.model.RoleDTO;
import com.rupesh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/roles")
public class RoleResource {

    private final RoleService roleService;

    @Autowired
    public RoleResource(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveRole(@RequestBody final RoleDTO roleDTO){
        return new ResponseEntity<>(roleService.saveRole(roleDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getRoleByName(@PathVariable final String name){
        return new ResponseEntity<>(roleService.getRoleByName(name), HttpStatus.OK);
    }
}
