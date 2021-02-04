package com.dev.crudStarterPack.services;
import com.dev.crudStarterPack.dto.DepartmentDTO;
import java.util.List;


public interface DepartmentService {
    List<DepartmentDTO> getAll();
    DepartmentDTO add(DepartmentDTO departmentDTO);
}
