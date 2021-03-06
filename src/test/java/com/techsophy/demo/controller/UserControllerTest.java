package com.techsophy.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techsophy.demo.application.port.UserServicePort;
import com.techsophy.demo.application.request.UserDTO;
import com.techsophy.demo.application.rest.UserController;
import com.techsophy.demo.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = UserController.class)
@ActiveProfiles("Test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServicePort userService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<UserDTO> userList;

    @BeforeEach
    void setUp() {
        this.userList = new ArrayList<>();
        this.userList.add(UserDTO.builder().id(1).name("Default Name").email("default@email.com").build());
        this.userList.add(UserDTO.builder().id(2).name("Default Name").email("default@email.com").build());
        this.userList.add(UserDTO.builder().id(3).name("Default Name").email("default@email.com").build());
    }

    /**
     * 1. Mock the results of our service calls
     * 2. We define our expectations and our API call using MockMvc
     * 3. The next step is to use MockMvc to make our API call and write our expectations:
     *
     * @throws Exception
     */
    @Test
    void shouldFindAll() throws Exception{

        when(userService.getAll()).thenReturn(userList);

        this.mockMvc
                .perform(get("/api/1.0.0/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(userList.size())))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    void shouldAddUser() throws  Exception{

//        Mock the user
        UserDTO user = UserDTO.builder().id(1).name("Default Name").email("default@email.com").build();
        when(userService.createUser(user)).thenReturn(user);

        this.mockMvc
                .perform(post("/api/1.0.0/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(user.getEmail())));

//        The final step is to capture the arguments passed to the service.create(..)
//        method by using Mockito???s ArgumentCaptor API:
//        Using the ArgumentCaptor we can verify if the JSON request matches the user input

        ArgumentCaptor<UserDTO> anyUser = forClass(UserDTO.class);
        verify(userService).createUser(anyUser.capture());
        assertThat(anyUser.getValue().getEmail()).isEqualTo("default@email.com");
    }


    @Test
    void userNotFoundException() throws  Exception{

        //Mock
        when(userService.getUser(10L)).thenThrow(new UserNotFoundException("10"));

        this.mockMvc
                .perform(get("/api/1.0.0/users/10"))
                .andExpect(status().isNotFound());
    }


}
