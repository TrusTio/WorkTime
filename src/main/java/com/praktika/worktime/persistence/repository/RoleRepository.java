package com.praktika.worktime.persistence.repository;


import com.praktika.worktime.persistence.entity.Role;
import com.praktika.worktime.persistence.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByAuthority(String authority);

}
