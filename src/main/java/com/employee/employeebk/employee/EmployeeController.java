package com.employee.employeebk.employee;

import com.employee.employeebk.utilModels.CustomApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/employee")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/api/employee")
    public CustomApiResponse save(@RequestBody EmployeeModel employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/api/employee")
    public CustomApiResponse update(@RequestBody EmployeeModel employeeModel) {
        return employeeService.update(employeeModel);
    }

    @DeleteMapping("/api/employee/{id}")
    public CustomApiResponse delete(@PathVariable int id) {
        return employeeService.delete(id);
    }

    @GetMapping("/api/employee/name/{name}")
    public List<EmployeeModel> getAllEmployeeByName(@PathVariable String name) {
        return employeeService.findAllByEmployeeName(name);
    }

    @GetMapping("/api/employee/number/{number}")
    public List<EmployeeModel> getEmployeeByNumber(@PathVariable long number) {
        return employeeService.getAllEmployeeByNumber(number);
    }
    @GetMapping("/api/employee/department/{departmentId}")
    public List<EmployeeModel> getEmployeeByDepartment(@PathVariable long departmentId) {
        return employeeService.getEmployeeByDepartment(departmentId);
    }

}
