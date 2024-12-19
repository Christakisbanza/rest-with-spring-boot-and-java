package com.apiRest.apiRestRestful.entity.dto;

import com.apiRest.apiRestRestful.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class UserUpdateDto {

    @NotBlank
    @Size(min = 1, max = 5)
    private Long id;

    @NotBlank
    @Size(min = 4, max = 55)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 11, max = 11)
    @CPF
    private String cpf;

    public UserUpdateDto() {
    }

    public UserUpdateDto(Long id, String name, String email, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public static User toUser(UserUpdateDto userUpdateDto){
        return new User(
                userUpdateDto.getId(),
                userUpdateDto.getName(),
                userUpdateDto.getEmail(),
                userUpdateDto.getCpf()
        );
    }

    public @NotBlank @Size(min = 1, max = 5) Long getId() {
        return id;
    }

    public void setId(@NotBlank @Size(min = 1, max = 5) Long id) {
        this.id = id;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 4, max = 55) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(min = 4, max = 55) String name) {
        this.name = name;
    }

    public @NotBlank @Size(min = 11, max = 11) @CPF String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @Size(min = 11, max = 11) @CPF String cpf) {
        this.cpf = cpf;
    }
}
