package com.rupesh.service;

import com.rupesh.model.RoleDTO;
import com.rupesh.repository.RoleRepository;
import com.rupesh.util.global.GlobalResponse;
import com.rupesh.util.mapper.RoleConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.rupesh.util.global.GlobalUtil.globalResponse;

@Service
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public GlobalResponse<RoleDTO> saveRole(final RoleDTO roleDTO) {
        return globalResponse(
                "user saved success.",
                HttpStatus.CREATED,
                Optional.ofNullable(roleRepository.save(RoleConvertor.toEntity(roleDTO)))
                        .map(RoleConvertor::toDto)
                        .orElse(null),
                null
        );
    }

    @Override
    public GlobalResponse<RoleDTO> getRoleByName(final String name) {
        return globalResponse(
                "user saved success.",
                HttpStatus.OK,
                roleRepository.findByName(name)
                        .map(RoleConvertor::toDto)
                        .orElse(null),
                null
        );
    }
}
