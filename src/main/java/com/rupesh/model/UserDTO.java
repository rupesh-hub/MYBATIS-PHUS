package com.rupesh.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private AddressDTO address;

}
