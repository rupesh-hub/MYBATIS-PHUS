package com.rupesh.util.mapper;

import com.rupesh.entity.User;
import com.rupesh.model.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserConvertor {

    public static User toEntity(final UserDTO source) {

        final User user = new User();

        user.setEmail(source.getEmail());
        user.setFirstName(source.getFirstName());
        user.setMiddleName(source.getMiddleName());
        user.setLastName(source.getLastName());
        user.setAddress(AddressConvertor.toEntity(source.getAddress()));
        return user;
    }

    public static UserDTO toDto(final User source) {
        final UserDTO userDTO = new UserDTO();

        userDTO.setEmail(source.getEmail());
        userDTO.setFirstName(source.getFirstName());
        userDTO.setMiddleName(source.getMiddleName());
        userDTO.setLastName(source.getLastName());
        userDTO.setAddress(AddressConvertor.toDto(source.getAddress()));

        return userDTO;
    }

    public static List<UserDTO> toDtoList(final List<User> userList) {
        return userList.stream().map(UserConvertor::toDto).collect(Collectors.toList());
    }

}
