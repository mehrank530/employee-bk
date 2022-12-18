package com.employee.employeebk.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/api/department")
    public List<DepartmentModel> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

}
