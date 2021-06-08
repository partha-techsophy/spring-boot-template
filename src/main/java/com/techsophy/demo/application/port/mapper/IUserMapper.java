package com.techsophy.demo.application.port.mapper;

import com.techsophy.demo.application.request.UserDTO;
import com.techsophy.demo.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User mapToUser(UserDTO dto);
    UserDTO mapToUserDTO(User user);

    List<User> mapToUserList(List<UserDTO> userDTOList);
    List<UserDTO> mapToUserDTOLIst(List<User> userList);
}
