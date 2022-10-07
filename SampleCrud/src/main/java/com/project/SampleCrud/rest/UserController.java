package com.project.SampleCrud.rest;

import com.project.SampleCrud.dto.UserDto;
import com.project.SampleCrud.dto.custom.ListResponseDto;
import com.project.SampleCrud.dto.custom.ResponseDto;
import com.project.SampleCrud.model.User;
import com.project.SampleCrud.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createUser(@RequestBody User user){
        ResponseDto response = userService.createUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable Integer userId){
        ResponseDto response = userService.getUser(userId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ListResponseDto> getAllUsers(){
        ListResponseDto response = userService.getAllUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable Integer userId,@RequestBody User user){
        ResponseDto response = userService.updateUser(userId,user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Integer userId){
        ResponseDto response = userService.deleteUser(userId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
