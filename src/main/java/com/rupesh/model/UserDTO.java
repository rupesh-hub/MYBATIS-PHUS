package com.rupesh.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String firstNameNP;
    private String middleNameNP;
    private String lastNameNP;
    private String email;
    private AddressDTO address;
    private List<RoleDTO> roleList;

}
