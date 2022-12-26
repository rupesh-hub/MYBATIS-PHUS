package com.rupesh.service;

import com.rupesh.mapper.UserMapper;
import com.rupesh.model.UserDTO;
import com.rupesh.repository.UserRepository;
import com.rupesh.util.mapper.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO saveUser(final UserDTO userDTO) {

        return Optional.ofNullable(userRepository.save(UserConvertor.toEntity(userDTO)))
                .map(UserConvertor::toDto)
                .orElse(null);

    }

    @Override
    public UserDTO updateUser(final UserDTO userDTO, final String userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUser(final Long userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public UserDTO deleteUser(final String userId) {
        return null;
    }

}
