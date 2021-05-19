package com.scubetech.demo.repository.port.mapper;

import com.scubetech.demo.domain.model.User;
import com.scubetech.demo.repository.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IUserEntityMapper {

    //This is the option available to access mapper. Looking for better option
    IUserEntityMapper INSTANCE = Mappers.getMapper(IUserEntityMapper.class);

    User mapToUser(UserEntity entity);
    UserEntity mapToEntity(User dot);

    List<User> mapToUserList(List<UserEntity> entityList);
    List<UserEntity> mapToUserEntity(List<User> userList);
}
