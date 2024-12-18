package com.apiRest.apiRestRestful.controller;



import com.apiRest.apiRestRestful.entity.User;
import com.apiRest.apiRestRestful.entity.dto.UserResponseDto;
import com.apiRest.apiRestRestful.entity.dto.UserSaveDto;
import com.apiRest.apiRestRestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody UserSaveDto userSaveDto){
        User user = userService.save(UserSaveDto.toUser(userSaveDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id){
        User user = userService.getById(id);
        return ResponseEntity.ok().body(UserResponseDto.toDto(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();
        return ResponseEntity.ok().body(users);
    }
}