package com.techsophy.demo.application.port;

import com.techsophy.demo.application.request.UserDTO;
import com.techsophy.demo.exception.ErrorReadingEntityException;
import com.techsophy.demo.exception.ErrorSavingEntityException;
import com.techsophy.demo.exception.UserNotFoundException;

import java.util.List;

/**
 * UserServicePort decouples the service implementation from controller.
 */
public interface UserServicePort {

    UserDTO createUser(UserDTO userDto) throws ErrorSavingEntityException;

    List<UserDTO> getAll() throws ErrorReadingEntityException;

    UserDTO getUser(Long id) throws ErrorReadingEntityException, UserNotFoundException;
}
