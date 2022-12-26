package com.rupesh.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address")
@DynamicUpdate
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq_gen")
    @SequenceGenerator(name = "address_id_seq_gen", sequenceName = "address_id_seq_gen", allocationSize = 1, initialValue = 1)
    private Long id;
    private String country;
    private String city;
    private String zone;
    private String street;

    @OneToOne(mappedBy = "address")
    private User user;

}
