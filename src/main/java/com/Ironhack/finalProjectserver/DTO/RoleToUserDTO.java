package com.Ironhack.finalProjectserver.DTO;

import com.Ironhack.finalProjectserver.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleToUserDTO {
    private String email;
    private Collection<Role> roleName;
}
