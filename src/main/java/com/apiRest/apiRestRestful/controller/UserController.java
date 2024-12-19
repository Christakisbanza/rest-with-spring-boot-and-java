package com.apiRest.apiRestRestful.controller;



import com.apiRest.apiRestRestful.entity.User;
import com.apiRest.apiRestRestful.entity.dto.UserResponseDto;
import com.apiRest.apiRestRestful.entity.dto.UserSaveDto;
import com.apiRest.apiRestRestful.entity.dto.UserUpdateDto;
import com.apiRest.apiRestRestful.mapper.Mapper;
import com.apiRest.apiRestRestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody UserSaveDto userSaveDto){
        User user = userService.save(Mapper.parseObj(userSaveDto, User.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(Mapper.parseObj(user, UserResponseDto.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id){
        User user = userService.getById(id);
        return ResponseEntity.ok().body(Mapper.parseObj(user,UserResponseDto.class));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll(){
        List<User> users = userService.getAll();
        return ResponseEntity.ok().body(Mapper.parseListObjs(users, UserResponseDto.class));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> update(@RequestBody UserUpdateDto userUpdateDto){
        User user = userService.update(UserUpdateDto.toUser(userUpdateDto));
        return ResponseEntity.ok().body(Mapper.parseObj(user, UserResponseDto.class));
    }
}
