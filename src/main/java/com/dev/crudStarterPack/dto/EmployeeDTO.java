package com.dev.crudStarterPack.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {
    Long id;
    Long employeeId;
    String employeeName;
    String employeeMobile;
    String employeeEmail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date employeeDate;
    //    Long departmentId;
//    String departmentName;
//    String departmentHead;
    DepartmentDTO department;
    AddressDTO address;

}
