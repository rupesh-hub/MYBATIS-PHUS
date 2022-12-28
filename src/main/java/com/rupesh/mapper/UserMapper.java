package com.rupesh.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rupesh.model.UserResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface UserMapper {

    Page<UserResponseDTO> getUser(final Page<UserResponseDTO> page, @Param("searchField") final Map<String, Object> searchField);

}
