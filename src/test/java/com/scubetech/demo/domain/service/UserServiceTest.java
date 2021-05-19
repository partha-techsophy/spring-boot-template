package com.scubetech.demo.domain.service;

import com.scubetech.demo.data.TestUserData;
import com.scubetech.demo.domain.model.User;
import com.scubetech.demo.domain.service.impl.UserServiceImpl;
import com.scubetech.demo.repository.port.UserRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepositoryPort userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void shouldSaveUserSuccessfully() throws Exception{

        User userToCreate = TestUserData.givenUserWithoutID();
        //Create sample User object and set all the properties
        when(userRepository.add(any(User.class))).thenReturn(userToCreate);

        //Create sample User object and set all the properties
        User savedUser = userService.createUser(userToCreate);

        //You have two ways to test, you can either verify that save method was invoked by
        //verify method
        verify(userRepository, times(1)).add(any(User.class));

        //or by assertion statements, match the email in the returned object to be equal
        //to the one set by you in the mocked object
        Assertions.assertEquals(savedUser.getName(), userToCreate.getName());
    }

    @Test
    void shouldGetUserById() throws  Exception{
        User user = TestUserData.givenUserWithID();
        when(userRepository.findById(TestUserData.USER_ID)).thenReturn(user);
        Assertions.assertEquals(userService.getUser(TestUserData.USER_ID), user);

    }

}
