package com.dev.crudStarterPack.model;
import lombok.Data;

import javax.persistence.*;

@Table(name = "Department")
@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long departmentId;
    String departmentName;
    String departmentHead;
}
