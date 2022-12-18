package com.employee.employeebk.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    List<EmployeeModel> findAllByEmployeeNumber(long value);
    List<EmployeeModel> findAllByEmployeeName(String name);
    EmployeeModel findEmployeeModelById(long id);
    List<EmployeeModel> findEmployeeModelsByDepartment_Id(long departmentId);


}
