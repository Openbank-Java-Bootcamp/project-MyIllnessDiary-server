package com.Ironhack.finalProjectserver.service.interfaces;

import com.Ironhack.finalProjectserver.model.Role;

public interface RoleServiceInterface {
    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
}
