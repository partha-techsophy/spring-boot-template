package com.scubetech.demo.application.port;

import com.scubetech.demo.application.request.UserDTO;
import com.scubetech.demo.exception.ErrorReadingEntityException;
import com.scubetech.demo.exception.ErrorSavingEntityException;
import com.scubetech.demo.exception.UserNotFoundException;

import java.util.List;

/**
 * UserServicePort decouples the service implementation from controller.
 */
public interface UserServicePort {

    UserDTO createUser(UserDTO userDto) throws ErrorSavingEntityException;

    List<UserDTO> getAll() throws ErrorReadingEntityException;

    UserDTO getUser(Long id) throws ErrorReadingEntityException, UserNotFoundException;
}
