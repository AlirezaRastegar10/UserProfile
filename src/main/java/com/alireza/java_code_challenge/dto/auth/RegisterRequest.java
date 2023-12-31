package com.alireza.java_code_challenge.dto.auth;


import com.alireza.java_code_challenge.dto.address.RegisterAddress;
import com.alireza.java_code_challenge.annotations.dateofbirth.ValidDateOfBirth;
import com.alireza.java_code_challenge.annotations.nationalcode.IranianNationalCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RegisterRequest implements Serializable {

    @NotBlank(message = "firstname cannot be empty.")
    @Size(min = 3, message = "firstname should have at least 3 characters.")
    @Pattern(regexp = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-])*$", message = "firstname can not have number and sign(!,@,#,%,...).")
    String firstname;

    @NotBlank(message = "lastname cannot be empty.")
    @Size(min = 3, message = "lastname should have at least 3 characters.")
    @Pattern(regexp = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-])*$", message = "lastname can not have number and sign(!,@,#,%,...).")
    String lastname;

    @NotBlank(message = "national code cannot be empty.")
    @Size(min = 10, max = 10, message = "national code must be 10 characters.")
    @IranianNationalCode
    String nationalCode;

    @ValidDateOfBirth
    String dateOfBirth;

    @NotBlank(message = "email cannot be empty.")
    @Email(message = "the email pattern is incorrect.")
    String email;

    @NotBlank(message = "password cannot be empty.")
    @Size(min = 8, max = 8, message = "password must be 8 characters.")
    @Pattern(regexp = "^(?=.*?\\d)(?=.*?[a-zA-Z])[a-zA-Z\\d]+$", message = "the password must contain numbers and letters.")
    String password;

    @NotNull(message = "the address must not be empty.")
    @Valid
    RegisterAddress address;
}
