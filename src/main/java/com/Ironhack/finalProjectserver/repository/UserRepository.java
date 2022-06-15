package com.Ironhack.finalProjectserver.repository;

import com.Ironhack.finalProjectserver.model.Role;
import com.Ironhack.finalProjectserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);

    @Query(value="SELECT name FROM user WHERE roles_id=1",nativeQuery = true)
    List<User> findAllByRoles_id(Long roleId);


}
