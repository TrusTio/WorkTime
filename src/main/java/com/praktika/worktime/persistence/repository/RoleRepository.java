package com.praktika.worktime.persistence.repository;


import com.praktika.worktime.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByAuthority(String authority);

}
