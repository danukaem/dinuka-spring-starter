package com.dev.crudStarterPack.controllers;
import com.dev.crudStarterPack.dto.DepartmentDTO;
import com.dev.crudStarterPack.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department-service")


public class DepartmentController {

    private  final DepartmentService departmentService;

    @GetMapping("/getAllDep")
    ResponseEntity<List<DepartmentDTO>>  all (){
        return  ResponseEntity.ok(departmentService.getAll());
    }

    @PutMapping("add")
    public  ResponseEntity<DepartmentDTO> add(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO departmentDTO1 = departmentService.add(departmentDTO);
        return ResponseEntity.created(URI.create("/add/" + departmentDTO1.getDepartmentName() + "/profile")).body(departmentDTO1);

    }
}
