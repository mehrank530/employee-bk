package com.employee.employeebk.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<DepartmentModel> getAllDepartment() {
        try {
            return departmentRepository.findAll();
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }
}
