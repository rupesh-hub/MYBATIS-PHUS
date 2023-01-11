package com.rupesh.service;

import com.rupesh.model.RoleDTO;
import com.rupesh.util.global.GlobalResponse;

public interface IRoleService {

    GlobalResponse<RoleDTO> saveRole(final RoleDTO roleDTO);
    GlobalResponse<RoleDTO> getRoleByName(final String name);

}
