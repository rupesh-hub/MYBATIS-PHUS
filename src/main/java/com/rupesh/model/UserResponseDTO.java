package com.rupesh.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private String fullName;
    private String email;
    private AddressDTO address;

}
