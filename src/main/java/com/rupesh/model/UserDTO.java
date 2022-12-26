package com.rupesh.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private String fullName;
    private String email;
    private AddressDTO address;

}
