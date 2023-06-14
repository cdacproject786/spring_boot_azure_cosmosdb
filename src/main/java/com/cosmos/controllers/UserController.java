package com.cosmos.controllers;

import com.cosmos.requestbeans.UserRequest;
import com.cosmos.responsebeans.UserResponse;
import com.cosmos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserRequest userRequest){
        UserResponse savedUser = this.userService.saveUser(userRequest);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<UserResponse> allUsers = this.userService.findAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id){
        UserResponse foundUserById = this.userService.findUserById(id);
        return new ResponseEntity<>(foundUserById,HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserRequest newUser){
        UserResponse updatedUser = this.userService.updateUser(newUser);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") String id){
        this.userService.deleteuser(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
