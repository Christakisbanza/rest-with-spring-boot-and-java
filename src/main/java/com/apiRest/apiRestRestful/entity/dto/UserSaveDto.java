package com.apiRest.apiRestRestful.entity.dto;

import com.apiRest.apiRestRestful.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class UserSaveDto {

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

    public UserSaveDto() {
    }

    public UserSaveDto(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
