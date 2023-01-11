package com.rupesh.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {

    private String fullNameEN;
    private String fullNameNP;
    private String email;
    private AddressDTO address;
    private List<String> roles;

}
