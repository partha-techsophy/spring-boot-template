package com.techsophy.demo.repository.jpa;

import com.techsophy.demo.repository.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA repository
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Find user by email
     * @param email
     * @return
     */
    Optional<UserEntity> findByEmail(String email);
}
