package com.praktika.worktime.service.impl;

import com.praktika.worktime.persistence.entity.User;
import com.praktika.worktime.persistence.repository.UserRepository;
import com.praktika.worktime.service.RoleService;
import com.praktika.worktime.service.UserService;
import com.praktika.worktime.service.models.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder encoder;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, RoleService roleService, PasswordEncoder encoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
    }


    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        if (userRepository.count() == 0) {
            roleService.seedRoles();
            userServiceModel.setAuthorities(roleService.findAll());
        } else {
            userServiceModel.setAuthorities(new LinkedHashSet<>());
            userServiceModel.getAuthorities().add(roleService.findByAuthority("ROLE_USER"));
        }

        User user = modelMapper.map(userServiceModel, User.class);
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);


        return modelMapper.map(savedUser,UserServiceModel.class);


    }



    @Override
    public boolean existByUsername(String username) {
        return false;
    }

    @Override
    public boolean existByEmail(String email) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with NOT FOUND: %s", username)));
    }
}
