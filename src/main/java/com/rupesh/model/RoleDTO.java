package com.rupesh.model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class RoleDTO {

    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }

}
