package com.employee.employeebk.department;

import com.employee.employeebk.employee.EmployeeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class DepartmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String departmentCode;
    private String description;
    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonIgnore
    private List<EmployeeModel> employees;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EmployeeModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeModel> employees) {
        this.employees = employees;
    }
}
