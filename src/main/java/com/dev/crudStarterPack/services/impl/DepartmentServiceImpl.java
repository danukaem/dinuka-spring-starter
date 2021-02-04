package com.dev.crudStarterPack.services.impl;
import com.dev.crudStarterPack.dto.DepartmentDTO;
import com.dev.crudStarterPack.dto.ModelMapper;
import com.dev.crudStarterPack.model.Department;
import com.dev.crudStarterPack.repository.DepartmentRepository;
import com.dev.crudStarterPack.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl  implements DepartmentService {

    private  final DepartmentRepository departmentRepository;
    private  final ModelMapper modelMapper;

    @Override
    public List<DepartmentDTO> getAll() {
        List<Department> dep =  departmentRepository.findAll();
        return   modelMapper.departmentToDto(dep);
    }

    @Override
    public DepartmentDTO add(DepartmentDTO departmentDTO) {
        Department department = modelMapper.departmentDtoToDepartment(departmentDTO);
        Department saveDepartment =departmentRepository.save(department);
        return  modelMapper.departmentToDepartmentDto(saveDepartment);

    }
}
