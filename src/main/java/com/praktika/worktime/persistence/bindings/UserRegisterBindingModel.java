package com.praktika.worktime.persistence.bindings;


import org.hibernate.validator.constraints.Length;

public class UserRegisterBindingModel extends BaseBindingModel {

    @Length
    private String username;
    private String email;
    private String password;

    public UserRegisterBindingModel() {
    }




}
