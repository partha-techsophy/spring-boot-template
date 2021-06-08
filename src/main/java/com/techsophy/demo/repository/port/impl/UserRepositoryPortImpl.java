package com.techsophy.demo.repository.port.impl;

import com.techsophy.demo.domain.model.User;
import com.techsophy.demo.exception.UserNotFoundException;
import com.techsophy.demo.repository.jpa.UserRepository;
import com.techsophy.demo.repository.jpa.entity.UserEntity;
import com.techsophy.demo.repository.port.UserRepositoryPort;
import com.techsophy.demo.repository.port.mapper.IUserEntityMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * JPA User repository port implementation
 */
@Service
public class UserRepositoryPortImpl implements UserRepositoryPort {

    private final UserRepository userRepository;

    private final MessageSource messageSource;

    Logger logger = LoggerFactory.getLogger(UserRepositoryPortImpl.class);

    @Autowired
    public UserRepositoryPortImpl(UserRepository userRepository,
                                  MessageSource messageSource) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
    }

    @Override
    @SneakyThrows
    public User add(User user) {
        return IUserEntityMapper
                .INSTANCE.mapToUser(
                        userRepository.save(IUserEntityMapper.INSTANCE.mapToEntity(user))
                );
    }

    @Override
    @SneakyThrows
    public User update(User user)  {
        return IUserEntityMapper
                .INSTANCE.mapToUser(
                        userRepository.save(IUserEntityMapper.INSTANCE.mapToEntity(user))
                );
    }

    @Override
    @SneakyThrows
    public void delete(User user)  {
        userRepository.delete(IUserEntityMapper.INSTANCE.mapToEntity(user));
    }

    @Override
    @SneakyThrows
    public List<User> all()  {
        return IUserEntityMapper.INSTANCE.mapToUserList(userRepository.findAll());
    }

    @Override
    @SneakyThrows
    public User findById(Long id)  {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            return IUserEntityMapper.INSTANCE.mapToUser(userOptional.get());
        } else {
            String message = messageSource.getMessage("user.notfound", null, Locale.getDefault());
            String formattedMessage = MessageFormat.format(message, id);
            logger.warn(formattedMessage);
            throw new UserNotFoundException(formattedMessage);
        }

    }

    @Override
    @SneakyThrows
    public User findByEmail(String email)  {
        Optional<UserEntity> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()) {
            return IUserEntityMapper.INSTANCE.mapToUser(userOptional.get());
        } else {
            throw new UserNotFoundException("User with this email not found");
        }
    }
}
