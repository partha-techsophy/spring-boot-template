package com.scubetech.demo.repository.port;

import com.scubetech.demo.domain.model.User;
import com.scubetech.demo.exception.ErrorReadingEntityException;
import com.scubetech.demo.exception.ErrorSavingEntityException;

import java.util.List;

/**
 * This UserRepositoryPort to decouple code from DB infrastructure changes
 */
public interface UserRepositoryPort {

    /**
     *
     * @param user
     * @return
     * @throws ErrorSavingEntityException
     */
    public User add(User user) throws ErrorSavingEntityException;

    /**
     * Update user
     * @param user
     * @return
     * @throws ErrorSavingEntityException
     */
    public User update(User user) throws ErrorSavingEntityException;

    /**
     * Delete user
     * @param user
     * @throws ErrorSavingEntityException
     */
    public void delete(User user) throws ErrorSavingEntityException;

    /**
     * List all users
     * @return
     * @throws ErrorReadingEntityException
     */
    public List<User> all() throws ErrorReadingEntityException;

    /**
     * Find by ID
     * @param id
     * @return
     * @throws ErrorReadingEntityException
     */
    public User findById(Long id) throws ErrorReadingEntityException;

    /**
     * Find by email
     * @param email
     * @return
     * @throws ErrorReadingEntityException
     */
    public User findByEmail(String email) throws ErrorReadingEntityException;


}
