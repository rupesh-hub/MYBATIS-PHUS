package com.rupesh.mapper;

import com.rupesh.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDTO> getUser(final Long userId);

}
