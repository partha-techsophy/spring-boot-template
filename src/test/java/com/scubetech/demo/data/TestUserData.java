package com.scubetech.demo.data;

import com.scubetech.demo.domain.model.User;

public class TestUserData {

    public static final Long USER_ID = 1L;
    public static final String EMAIL = "mail@email.com";
    public static final String PASSWORD = "password";
    public static final String NAME = "name";

    public static User givenUserWithoutID() {

        return User.builder()
                .email(EMAIL)
                .name(NAME)
                .password(PASSWORD)
                .build();
    }

    public static User givenUserWithID() {

        return User.builder()
                .id(USER_ID)
                .email(EMAIL)
                .name(NAME)
                .password(PASSWORD)
                .build();
    }


}
