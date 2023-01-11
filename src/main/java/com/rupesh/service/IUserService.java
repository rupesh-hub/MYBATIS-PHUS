package com.rupesh.service;

import com.rupesh.model.UserDTO;
import com.rupesh.model.UserResponseDTO;
import com.rupesh.pagination.PagingRequest;
import com.rupesh.util.global.GlobalResponse;

import java.util.List;

public interface IUserService {

    GlobalResponse<UserDTO> saveUser(final UserDTO userDTO);
    GlobalResponse<List<UserResponseDTO>> getAllUser(final PagingRequest pagingRequest);
    GlobalResponse<UserDTO> assignRole(final String roleName, final Long userId);
    GlobalResponse<UserDTO> removeAssignedRole(final String roleName, final Long userId);

}
