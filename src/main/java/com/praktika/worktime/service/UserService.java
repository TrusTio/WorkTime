package com.praktika.worktime.service;

import com.praktika.worktime.service.models.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    boolean existByUsername(String username);
    UserServiceModel register(UserServiceModel userServiceModel);
    boolean existByEmail(String email);

}
