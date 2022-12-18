package com.employee.employeebk.department;

import com.employee.employeebk.employee.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
    DepartmentModel findDepartmentModelById(long id);

}
