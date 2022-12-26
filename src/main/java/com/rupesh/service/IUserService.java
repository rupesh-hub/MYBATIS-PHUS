package com.rupesh.service;

import com.rupesh.model.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO saveUser(final UserDTO userDTO);

    UserDTO updateUser(final UserDTO userDTO, final String userId);

    List<UserDTO> getAllUser(final Long userId);

    UserDTO deleteUser(final String userId);
}
