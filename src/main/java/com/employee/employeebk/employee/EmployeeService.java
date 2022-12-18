package com.employee.employeebk.employee;

import com.employee.employeebk.department.DepartmentModel;
import com.employee.employeebk.department.DepartmentRepository;
import com.employee.employeebk.utilModels.CustomApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CustomApiResponse apiResponse;


    public List<EmployeeModel> getAllEmployee() {
        try {
            return employeeRepository.findAll();
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }


    public List<EmployeeModel> findAllByEmployeeName(String name) {
        try {
            return employeeRepository.findAllByEmployeeName(name);
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }


    public CustomApiResponse save(EmployeeModel employee) {
        try {
            List<EmployeeModel> employeeExist =  employeeRepository.findAllByEmployeeNumber(employee.getEmployeeNumber());
            if(employeeExist.size()>0) {
                apiResponse.setStatus(400);
                apiResponse.setMessage("employee already exists with employee number");
            }else{
                DepartmentModel departmentModel = departmentRepository.findDepartmentModelById(employee.getDepartment().getId());
                employee.setDepartment(departmentModel);
                EmployeeModel employeeModel = employeeRepository.save(employee);
                if (employeeModel != null) {
                    apiResponse.setStatus(200);
                    apiResponse.setMessage("employee added successfully");
                } else {
                    apiResponse.setStatus(400);
                    apiResponse.setMessage("failed to add employee ");
                }
            }
            return apiResponse;
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }


    public CustomApiResponse update(EmployeeModel employee) {
        try {
            EmployeeModel employeeModel = employeeRepository.findEmployeeModelById(employee.getId());
            DepartmentModel departmentModel = departmentRepository.findDepartmentModelById(employee.getDepartment().getId());
            employeeModel.setEmployeeName(employee.getEmployeeName());
            employeeModel.setEmployeeNumber(employee.getEmployeeNumber());
            employeeModel.setDepartment(departmentModel);
            employeeModel.setDateOfJoining(employee.getDateOfJoining());
            employeeModel.setSalary(employee.getSalary());
             EmployeeModel e = employeeRepository.save(employeeModel);
            if(e != null){
                apiResponse.setStatus(200);
                apiResponse.setMessage("employee updated successfully");
            }else{
                apiResponse.setStatus(400);
                apiResponse.setMessage("failed to update employee ");
            }
            return apiResponse;

        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }

    public CustomApiResponse delete(long id) {
        try {
            EmployeeModel employeeModel = employeeRepository.findEmployeeModelById(id);
            System.out.println(employeeModel);
            if (employeeModel != null) {
                employeeRepository.delete(employeeModel);
                apiResponse.setStatus(200);
                apiResponse.setMessage("Employee deleted successfully.");
                return apiResponse;
            } else {
                apiResponse.setStatus(404);
                apiResponse.setMessage("Employee not found.");
                return apiResponse;
            }
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }

    public List<EmployeeModel> getAllEmployeeByNumber(long employeeNumber) {
        try {
            return employeeRepository.findAllByEmployeeNumber(employeeNumber);
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }


    public List<EmployeeModel> getEmployeeByDepartment(long departmentId) {
        try {
            return employeeRepository.findEmployeeModelsByDepartment_Id(departmentId);
        } catch (Exception ex) {
            ex.getStackTrace();
            return null;
        }
    }


}
