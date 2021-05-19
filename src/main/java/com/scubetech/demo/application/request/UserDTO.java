package com.scubetech.demo.application.request;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Data transfer object
 */

/**
 * Lombok is used for Annotation based getter/setter. Configure this in your favourite IDE.
 * For IntelliJ - Go to plugin and searech for Lombok, install and follow the instruction
 * For eclipes - Refer the following link https://projectlombok.org/setup/eclipse
 *
 */
@Value
@RequiredArgsConstructor
//this is required for mock test at controller
@NoArgsConstructor (force = true)
@Builder(toBuilder = true)
public class UserDTO {
    long id;

    /**
     * Auto validate email using @Validated in controller
     */
    @Builder.Default // this is required for mock test
    @Email(message = "Invalid email") String email = "default@email.com";

    /**
     * Empty or null password check using @Validated in controller
     * Pattern also can be used to validate
     * @Pattern(regexp = "", "Password must have at least one capital later and one special character ")
     */
    @NotEmpty(message = "Invalid password")
    @Builder.Default // this is required for mock test
    @Size(min = 6, max = 16, message = "Password must be minimum 6 character and maximum 16 character") String password = "password01";

    /**
     * Validate name with min/max size
     */
    @NotEmpty(message = "Invalid name")
    @Builder.Default // this is required for mock test
    @Size(min = 3, max = 90, message = "Name must be min 3 characters") String name = "Scott Tiger";
}
