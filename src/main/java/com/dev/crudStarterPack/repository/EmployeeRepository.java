package com.dev.crudStarterPack.repository;
import com.dev.crudStarterPack.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where (?1 is NULL or e.employeeId  like  ?1) and (?2 is NULL or e.employeeName like %?2%) and (?3 is NULL or e.employeeMobile  like %?3%)")
    Page <Employee> findByName( Long employeeId  , String employeeName , String employeeMobile  , Pageable pageable);

}
