package com.apiRest.apiRestRestful.entity.dto;

import com.apiRest.apiRestRestful.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDto {

    private String name;
    private String email;

    public UserResponseDto() {
    }

    public UserResponseDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static UserResponseDto toDto (User user){
        return new UserResponseDto(
                user.getName(),
                user.getEmail()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
