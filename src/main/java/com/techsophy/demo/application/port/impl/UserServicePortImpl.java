package com.techsophy.demo.application.port.impl;

import com.techsophy.demo.application.port.UserServicePort;
import com.techsophy.demo.application.port.mapper.IUserMapper;
import com.techsophy.demo.application.request.UserDTO;
import com.techsophy.demo.domain.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServicePortImpl implements UserServicePort {

    private final UserService userService;

    @Autowired
    public UserServicePortImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @SneakyThrows
    public UserDTO createUser(UserDTO userDto) {
        return IUserMapper.INSTANCE.mapToUserDTO(
                userService.createUser(IUserMapper.INSTANCE.mapToUser(userDto))
        );
    }

    @Override
    @SneakyThrows
    public List<UserDTO> getAll()  {
        return userService.getAll()
                .stream()
                .map(IUserMapper.INSTANCE::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
    public UserDTO getUser(Long id)  {
        return  IUserMapper.INSTANCE.mapToUserDTO(userService.getUser(id));
    }
}
