package org.ms.authentificationservice.web;

import lombok.AllArgsConstructor;
import org.ms.authentificationservice.entities.AppRole;
import org.ms.authentificationservice.entities.AppUser;
import org.ms.authentificationservice.entities.UserRoleCollection;
import org.ms.authentificationservice.services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserServiceREST {
    private final UserServiceImpl userService;
    @RequestMapping
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping(path = "/users")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
    }
    @PostMapping(path = "/roles")
    public ResponseEntity<AppRole> saveRole(@RequestBody AppRole role){
        return new ResponseEntity<>(userService.addRole(role), HttpStatus.OK);
    }
    @PostMapping(path = "/addRoleToUser")
    public ResponseEntity<AppUser> addRoleToUser2(@RequestBody UserRoleCollection col){
        return new ResponseEntity<>(userService.addRoleToUser(col.getUsername(), col.getRoleName()), HttpStatus.OK);

    }
}
