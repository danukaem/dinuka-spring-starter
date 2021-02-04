package com.dev.crudStarterPack.repository;
import com.dev.crudStarterPack.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
