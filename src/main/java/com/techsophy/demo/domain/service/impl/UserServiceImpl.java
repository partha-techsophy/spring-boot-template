package com.techsophy.demo.domain.service.impl;

import com.techsophy.demo.domain.model.User;
import com.techsophy.demo.domain.service.UserService;
import com.techsophy.demo.repository.port.UserRepositoryPort;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

/**
 * This is the implementation of UserService interface
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepositoryPort userRepository;

    @Autowired
    public UserServiceImpl(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @SneakyThrows
    public User createUser(User user) {
        user = userRepository.add(user);

        return user;

    }

    @Override
    @SneakyThrows
    public void updateEmail(Long id, String email) {

        User user = userRepository.findById(id);
        user.changeEmail(email);
        userRepository.update(user);
    }

    @Override
    @SneakyThrows
    public void updatePassword(Long id, String password) {

        User user = userRepository.findById(id);
        user.changePassword(password);
        userRepository.update(user);
    }

    @Override
    @SneakyThrows
    public boolean validateLogin(String email, String password)  {

        User user = userRepository.findByEmail(email);
        return user.validatePassword(password);
    }

    @Override
    @SneakyThrows
    public User getUser(Long id)  {

        return userRepository.findById(id);
    }

    @Override
    @SneakyThrows
    public List<User> getAll()  {
        return  userRepository.all();
    }

    @Override
    @SneakyThrows
    public List<User> getAll(int start, int rows)  {
        return Collections.emptyList();
    }


}
