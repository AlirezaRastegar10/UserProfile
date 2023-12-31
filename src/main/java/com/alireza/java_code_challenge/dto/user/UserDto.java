package com.alireza.java_code_challenge.dto.user;


import com.alireza.java_code_challenge.dto.address.AddressDto;
import com.alireza.java_code_challenge.entity.enumeration.Role;
import com.alireza.java_code_challenge.entity.enumeration.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserDto implements Serializable {

    Long id;
    String firstname;
    String lastname;
    String nationalCode;
    Integer age;
    String email;
    Role role;
    Status status;
    LocalDateTime registerDate;
    AddressDto address;
}
