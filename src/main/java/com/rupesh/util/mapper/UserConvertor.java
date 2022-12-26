package com.rupesh.util.mapper;

import com.rupesh.entity.User;
import com.rupesh.model.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserConvertor {

    public static User toEntity(final UserDTO source) {

        final User user = new User();

        user.setEmail(source.getEmail());
        user.setFullName(source.getFullName());
        user.setAddress(AddressMapper.toEntity(source.getAddress()));
        return user;
    }

    public static UserDTO toDto(final User source) {
        final UserDTO userDTO = new UserDTO();

        userDTO.setEmail(source.getEmail());
        userDTO.setFullName(source.getFullName());
        userDTO.setAddress(AddressMapper.toDto(source.getAddress()));

        return userDTO;
    }

    public static List<UserDTO> toDtoList(final List<User> userList) {
        return userList.stream().map(UserConvertor::toDto).collect(Collectors.toList());
    }

}
