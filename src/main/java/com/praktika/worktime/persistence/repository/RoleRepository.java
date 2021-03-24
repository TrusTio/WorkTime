package com.praktika.worktime.persistence.repository;


import com.praktika.worktime.persistence.entity.Role;
import com.praktika.worktime.persistence.entity.RoleName;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(RoleName roleName);

}
