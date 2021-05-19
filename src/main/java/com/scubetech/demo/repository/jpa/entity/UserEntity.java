package com.scubetech.demo.repository.jpa.entity;

import lombok.*;
import lombok.experimental.NonFinal;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Root Aggregate for User domain. This should own the user domain. Any data should not be
 * leaked from this domain using getter and setter
 * Never allow developer to construct domain object directly. Encapsulate everyting and allow only
 * behavior that can be managed
 * TODO - Remove default getter/setter and add only specified getter/setter
 */

@Entity
@Table(name = "T_USER")
@Value
@Builder(toBuilder = true)
@RequiredArgsConstructor
@NoArgsConstructor(force = true) // This ir required for Mapper
@NonFinal //This is required for Mockito
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    @NotEmpty(message = "Email should not be empty")
    @Column(nullable = false, unique = true, length = 100)
    @NonNull  String email;

    @Column(nullable = false, length = 100)
    @NonNull  String password;

    @Column(nullable = false, length = 100)
    @NonNull  String name;

}
