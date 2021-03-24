package com.praktika.worktime.service;

import com.praktika.worktime.persistence.entity.Role;
import com.praktika.worktime.persistence.entity.RoleName;
import com.praktika.worktime.persistence.entity.User;
import com.praktika.worktime.persistence.repository.RoleRepository;
import com.praktika.worktime.persistence.repository.UserRepository;
import com.praktika.worktime.service.dto.SignupUserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    public SignupUserDTO signUp(SignupUserDTO signupUserDTO) {
        if (userRepository.existsByUsername(signupUserDTO.getUsername())) {
            throw new RuntimeException("Username taken!");
        }

        Role role = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(RuntimeException::new);

        User user = new User()
                .setUsername(signupUserDTO.getUsername())
                .setPassword(bCryptPasswordEncoder.encode(signupUserDTO.getPassword()))
                .setRoles(Collections.singleton(role));

       return modelMapper.map(user, SignupUserDTO.class);
    }
}
