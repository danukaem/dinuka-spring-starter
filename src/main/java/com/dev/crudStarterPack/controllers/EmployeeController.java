package com.dev.crudStarterPack.controllers;
import com.dev.crudStarterPack.dto.EmployeeDTO;
import com.dev.crudStarterPack.model.Employee;
import com.dev.crudStarterPack.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employee-services")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all")
    ResponseEntity<List<EmployeeDTO>> all() {
        return  ResponseEntity.ok(employeeService.getAll());
    }


    @GetMapping("/search")
    Page<Employee> search(@RequestParam  (required = false ) Long employeeId ,
                          @RequestParam  (required = false )String employeeName ,
                          @RequestParam  (required = false )String employeeMobile,
                          @RequestParam int first ,
                          @RequestParam  int maxResult){
        return   employeeService.searchEmployee( employeeId , employeeName , employeeMobile , first, maxResult );
    }

    @PutMapping("/add")
    public ResponseEntity<EmployeeDTO> add(@RequestBody EmployeeDTO employeeDTO ){
        EmployeeDTO createdEmployee = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.created(URI.create("/users/" + createdEmployee.getEmployeeName() + "/profile")).body(createdEmployee);
    }

    @GetMapping("/download/employee.xlsx")
    public  void downloadCsv(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=employee.xlsx");
        ByteArrayInputStream stream = employeeService.EmployeeListToExcel(employeeService.getAll());
        IOUtils.copy(stream, response.getOutputStream());
    }

}
