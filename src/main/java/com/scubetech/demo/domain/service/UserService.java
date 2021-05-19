package com.scubetech.demo.domain.service;

import com.scubetech.demo.domain.model.User;
import com.scubetech.demo.exception.ErrorReadingEntityException;
import com.scubetech.demo.exception.ErrorSavingEntityException;
import com.scubetech.demo.exception.InvalidInputException;

import java.util.List;

/**
 * This is the user service interface that defines all the business logic/ use case for user domain
 */
public interface UserService {


    /**
     * Create user
     * @param User
     * @return
     * @throws ErrorSavingEntityException
     */
    User createUser(User user) throws ErrorSavingEntityException;

    /**
     * Update email
     * @param id
     * @param email
     * @throws ErrorSavingEntityException
     */
    void updateEmail(Long id, String email) throws ErrorSavingEntityException;

    /**
     * Update password
     * @param id
     * @param password
     * @throws ErrorSavingEntityException
     */
    void updatePassword(Long id, String password) throws ErrorSavingEntityException;

    /**
     * Validate login
     * @param email
     * @param password
     * @return
     * @throws InvalidInputException
     */
    boolean validateLogin(String email, String password) throws InvalidInputException;

    /**
     * Find user by ID
     * @param id
     * @return
     * @throws ErrorReadingEntityException
     */
    User getUser(Long id) throws ErrorReadingEntityException;

    /**
     * List all users
     * Extend this function to use pagination
     * @return
     * @throws ErrorReadingEntityException
     */
    List<User> getAll() throws  ErrorReadingEntityException;

    /**
     * List user with pagination
     * Extend this function to use sorting
     * @param start
     * @param rows
     * @return
     * @throws ErrorReadingEntityException
     */
    List<User> getAll(int start, int rows) throws  ErrorReadingEntityException;
}
