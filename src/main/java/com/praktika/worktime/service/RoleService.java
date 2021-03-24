package com.praktika.worktime.service;


import com.praktika.worktime.service.models.RoleServiceModel;

import java.util.Set;

public interface RoleService {
    void seedRoles();

    Set<RoleServiceModel> findAll();

    RoleServiceModel findByAuthority(String authority);
}
