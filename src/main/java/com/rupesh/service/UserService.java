package com.rupesh.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rupesh.mapper.UserMapper;
import com.rupesh.model.UserDTO;
import com.rupesh.model.UserResponseDTO;
import com.rupesh.pagination.Pagination;
import com.rupesh.pagination.PagingRequest;
import com.rupesh.repository.UserRepository;
import com.rupesh.util.global.GlobalResponse;

import static com.rupesh.util.global.GlobalUtil.*;

import com.rupesh.util.mapper.UserConvertor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final SqlSessionTemplate sqlSessionTemplate;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserMapper userMapper,
                       SqlSessionTemplate sqlSessionTemplate) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.sqlSessionTemplate = sqlSessionTemplate;
        this.userMapper = this.sqlSessionTemplate.getMapper(UserMapper.class);
    }

    @Override
    public GlobalResponse<UserDTO> saveUser(final UserDTO userDTO) {

        return globalResponse(
                "user saved success.",
                HttpStatus.CREATED,
                Optional.ofNullable(userRepository.save(UserConvertor.toEntity(userDTO)))
                        .map(UserConvertor::toDto)
                        .orElse(null),
                null
        );

    }

    @Override
    public GlobalResponse<List<UserResponseDTO>> getAllUser(final PagingRequest pagingRequest) {
        final Long current = getCurrentPage(pagingRequest.getCurrentPage()); // DEFAULT : 1
        final Long size = getPageSize(pagingRequest.getPageSize()); // DEFAULT : 10
        final Map<String, Object> searchField = pagingRequest.getSearchField();

        final Page<UserResponseDTO> page = userMapper.getUser(new Page(current, size), searchField);

        return globalResponse(
                "user record fetch success.",
                HttpStatus.OK,
                page.getRecords(),
                new Pagination(page.getTotal(),
                        page.getSize(),
                        page.getCurrent(),
                        page.getPages())
        );
    }

}
