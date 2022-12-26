package com.rupesh.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressDTO {

    private String country;
    private String city;
    private String zone;
    private String street;
}
