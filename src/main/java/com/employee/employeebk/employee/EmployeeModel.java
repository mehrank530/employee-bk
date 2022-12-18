package com.employee.employeebk.employee;

import com.employee.employeebk.department.DepartmentModel;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long employeeNumber;
    private String employeeName;
    private LocalDate dateOfJoining;
    private long salary;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "department_id"), name="department_id")
    private DepartmentModel department;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }
}
