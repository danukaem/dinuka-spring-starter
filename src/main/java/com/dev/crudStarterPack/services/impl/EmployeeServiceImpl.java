package com.dev.crudStarterPack.services.impl;
import com.dev.crudStarterPack.dto.EmployeeDTO;
import com.dev.crudStarterPack.dto.ModelMapper;
import com.dev.crudStarterPack.model.Address;
import com.dev.crudStarterPack.model.Employee;
import com.dev.crudStarterPack.repository.AddressRepository;
import com.dev.crudStarterPack.repository.EmployeeRepository;
import com.dev.crudStarterPack.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.springframework.data.domain.PageRequest;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl  implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;


    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> emp = employeeRepository.findAll();
        return modelMapper.employeeToDto(emp);
    }

    @Override
    public Page<Employee> searchEmployee(Long employeeId , String employeeName , String  employeeMobile , int first , int maxResult) {
     return employeeRepository.findByName(  employeeId ,  employeeName  , employeeMobile , PageRequest.of( first , maxResult )  );
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.employeeDtoToEmployee(employeeDTO);

        employee.setEmployeeDate(new Date());
        Address address = addressRepository.save(employee.getAddress());
        employee.setAddress(address);
        Employee saveEmployee = employeeRepository.save(employee);
        return modelMapper.employeeToEmployeeDto(saveEmployee);
    }

    @Override
    public ByteArrayInputStream EmployeeListToExcel(List<EmployeeDTO> employeeDTOList) {

        try(Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employees");

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Cell cell = row.createCell(0);
            cell.setCellValue("Employee Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Employee Mobile Number");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Employee Email");
            cell.setCellStyle(headerCellStyle);

            for(int i = 0; i < employeeDTOList.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(employeeDTOList.get(i).getEmployeeName());
                dataRow.createCell(1).setCellValue(employeeDTOList.get(i).getEmployeeMobile());
                dataRow.createCell(2).setCellValue(employeeDTOList.get(i).getEmployeeEmail());
            }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}




