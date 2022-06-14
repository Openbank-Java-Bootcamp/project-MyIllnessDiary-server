package com.Ironhack.finalProjectserver.repository;

import com.Ironhack.finalProjectserver.model.Role;
import com.Ironhack.finalProjectserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);




}
