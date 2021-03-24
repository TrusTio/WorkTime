package com.praktika.worktime.persistence.bindings;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRegisterBindingModel extends BaseBindingModel {

    @Length
    private String username;
    private String email;
    private String password;

    public UserRegisterBindingModel() {

    }
    @Length(min = 2 , max = 20,message = "Name length should be between 2-20")
    @NotBlank
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Email(message = "Enter valid email")
    @NotBlank
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Length(min = 6 , max = 30,message = "Password length should be between 2-20")
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
