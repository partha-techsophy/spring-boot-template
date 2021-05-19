package com.scubetech.demo.application.rest;

import com.scubetech.demo.application.request.UserDTO;
import com.scubetech.demo.application.response.ApiResponse;
import com.scubetech.demo.application.response.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest end point
 * standard format is /{project-name}/{version}/{resource}
 */
@RequestMapping("/api/1.0.0/users")
public interface UserController {

    /**
     * Add user
     * @param userDTO
     * @return
     *
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<SimpleResponse> createUser(@RequestBody @Validated UserDTO userDTO) ;

    /**
     * List users
     * @return
     *
     */
    @GetMapping
    ApiResponse<List<UserDTO>> getAllUsers() ;

    /**
     * Get user by ID
     * @param id
     * @return
     *
     */
    @GetMapping("/{id}")
    ApiResponse<UserDTO> getUserById(@PathVariable Long id) ;
}
