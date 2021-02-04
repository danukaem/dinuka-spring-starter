package com.dev.crudStarterPack.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long addressId;
    String stressName;
    String city;
    @OneToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    Employee employee;

}
