package com.dev.crudStarterPack.dto;

import com.dev.crudStarterPack.model.Employee;
import lombok.Data;

@Data

public class AddressDTO {

    long addressId;
    String stressName;
    String city;
    Employee employee;
}
