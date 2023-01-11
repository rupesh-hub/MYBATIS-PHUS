package com.rupesh.util.mapper;

import com.rupesh.entity.Role;
import com.rupesh.model.RoleDTO;

public class RoleConvertor {

    public static Role toEntity(final RoleDTO roleDTO){
        return new Role(roleDTO.getName());
    }

    public static RoleDTO toDto(final Role role){
        return new RoleDTO(role.getName());
    }

}
