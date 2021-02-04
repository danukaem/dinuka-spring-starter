package com.dev.crudStarterPack.dto;

import com.dev.crudStarterPack.model.Address;
import com.dev.crudStarterPack.model.Department;
import com.dev.crudStarterPack.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    List<EmployeeDTO> employeeToDto(List<Employee> employee);

    @Mapping(target = "department.departmentId", source = "department.departmentId")
    @Mapping(target = "department.departmentName", source = "department.departmentName")
    @Mapping(target = "department.departmentHead", source = "department.departmentHead")
    @Mapping(target = "address.addressId", source = "address.addressId")
    @Mapping(target = "address.stressName", source = "address.stressName")
    @Mapping(target = "address.city", source = "address.city")
    EmployeeDTO employeeToEmployeeDto(Employee employee);

    @Mapping(target = "department.departmentName", source = "department.departmentName")
    @Mapping(target = "department.departmentId", source = "department.departmentId")
    @Mapping(target = "department.departmentHead", source = "department.departmentHead")
    @Mapping(target = "address.addressId", source = "address.addressId")
    @Mapping(target = "address.stressName", source = "address.stressName")
    @Mapping(target = "address.city", source = "address.city")
    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);

    List<DepartmentDTO> departmentToDto(List<Department> departments);

    DepartmentDTO departmentToDepartmentDto(Department department);

    Department departmentDtoToDepartment(DepartmentDTO departmentDTO);


    @Mapping(target = "employee.id", source = "employee.id")
    @Mapping(target = "employee.employeeId", source = "employee.employeeId")
    @Mapping(target = "employee.employeeName", source = "employee.employeeName")
    @Mapping(target = "employee.employeeMobile", source = "employee.employeeMobile")
    @Mapping(target = "employee.employeeEmail", source = "employee.employeeEmail")
    @Mapping(target = "employee.employeeDate", source = "employee.employeeDate")
    @Mapping(target = "employee.department", source = "employee.department")
    AddressDTO addressToAdressDTO(Address address);

    @Mapping(target = "employee.id", source = "employee.id")
    @Mapping(target = "employee.employeeId", source = "employee.employeeId")
    @Mapping(target = "employee.employeeName", source = "employee.employeeName")
    @Mapping(target = "employee.employeeMobile", source = "employee.employeeMobile")
    @Mapping(target = "employee.employeeEmail", source = "employee.employeeEmail")
    @Mapping(target = "employee.employeeDate", source = "employee.employeeDate")
    @Mapping(target = "employee.department", source = "employee.department")
    Address addressDTOToAdress(AddressDTO address);


}



