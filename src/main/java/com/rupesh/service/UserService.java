package com.rupesh.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rupesh.entity.Role;
import com.rupesh.entity.User;
import com.rupesh.mapper.UserMapper;
import com.rupesh.model.UserDTO;
import com.rupesh.model.UserResponseDTO;
import com.rupesh.pagination.Pagination;
import com.rupesh.pagination.PagingRequest;
import com.rupesh.repository.RoleRepository;
import com.rupesh.repository.UserRepository;
import com.rupesh.util.global.GlobalResponse;
import com.rupesh.util.mapper.RoleConvertor;
import com.rupesh.util.mapper.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.rupesh.util.global.GlobalUtil.*;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserMapper userMapper,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

    /**
     * save user, address, and roles
     * @param userDTO
     * @return
     */
    @Override
    public GlobalResponse<UserDTO> saveUser(final UserDTO userDTO) {

        final User user = UserConvertor.toEntity(userDTO);
        userDTO.getRoleList().forEach(role -> {
            user.addRole(roleRepository.findByName(role.getName()).orElseThrow(() -> new RuntimeException("no role found.")));
        });

        return saveUser(user);
    }

    /**
     * get all users with their address as well as role names assigned to them
     *
     * @param pagingRequest
     * @return
     */
    @Override
    public GlobalResponse<List<UserResponseDTO>> getAllUser(final PagingRequest pagingRequest) {

        final Long current = getCurrent(pagingRequest.getCurrentPage()); // DEFAULT : 1
        final Long size = getSize(pagingRequest.getPageSize()); // DEFAULT : 10
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

    /**
     * assign and re-assign role to the user and return global response
     *
     * @param roleName
     * @param userId
     * @return
     */
    @Override
    public GlobalResponse<UserDTO> assignRole(final String roleName, final Long userId) {
        final User user = getUser(userId);
        final Role role = getRole(roleName);

        user.addRole(role);

        return saveUser(user);
    }

    /**
     * method to remove already assign role of user
     * @param roleName
     * @param userId
     * @return
     */
    @Override
    public GlobalResponse<UserDTO> removeAssignedRole(final String roleName, final Long userId) {
        final User user = getUser(userId);
        final Role role = getRole(roleName);

        user.removeRole(role);

        return saveUser(user);
    }

    /**
     * save user and return global response
     * helper method to reduce boilerplate code
     * @param user
     * @return
     */
    private GlobalResponse<UserDTO> saveUser(final User user) {
        return globalResponse(
                "user saved success.",
                HttpStatus.CREATED,
                Optional.ofNullable(userRepository.save(user))
                        .map(UserConvertor::toDto)
                        .orElse(null),
                null
        );
    }

    /**
     * method to get role by role name
     * @param roleName
     * @return
     */
    private Role getRole(final String roleName) {
        return roleRepository
                .findByName(roleName)
                .orElseThrow(() ->
                        new RuntimeException(String.format("role by role name [%s] not found.", roleName)));
    }

    /**
     * method to get user by user id
     * @param userId
     * @return
     */
    private User getUser(final Long userId){
        return userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException(String.format("user by user id [%s] not found.", userId)));
    }

}
