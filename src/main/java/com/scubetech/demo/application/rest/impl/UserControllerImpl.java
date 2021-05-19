package com.scubetech.demo.application.rest.impl;

import com.scubetech.demo.application.port.UserServicePort;
import com.scubetech.demo.application.request.UserDTO;
import com.scubetech.demo.application.response.ApiResponse;
import com.scubetech.demo.application.response.SimpleResponse;
import com.scubetech.demo.application.rest.UserController;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller is decoupled from service and domain using service port
 * Error handling is done using @RestControllerAdvice. See com.techsophy.demo.exception package
 */

@RestController
public class UserControllerImpl implements UserController {

    private final UserServicePort userService;

    @Autowired
    public UserControllerImpl(UserServicePort userService) {
        this.userService = userService;
    }

    @Override
    @SneakyThrows
    public ApiResponse<SimpleResponse> createUser(UserDTO userDTO)  {
        UserDTO dto = userService.createUser(userDTO);
        return new ApiResponse<>(SimpleResponse.builder().id(String.valueOf(dto.getId())).build(), true, "Added");

    }

    @Override
    @SneakyThrows
    public ApiResponse<List<UserDTO>> getAllUsers()  {
        return new ApiResponse<>(userService.getAll(), true, "Success");
    }

    @Override
    @SneakyThrows
    public ApiResponse<UserDTO> getUserById(Long id)  {
        return new ApiResponse<>(userService.getUser(id), true, "Success");
    }
}
