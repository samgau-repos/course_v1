package com.samgau.start.common.util;

import com.samgau.start.model.Department;
import com.samgau.start.model.Employee;
import com.samgau.start.model.dto.DepartmentDTO;
import com.samgau.start.model.dto.EmployeeDTO;

public final class TransferUtil {

    private TransferUtil() {
    }

    public static EmployeeDTO getAsEmployeeDTO(Employee source) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(source.getId());
        employeeDTO.setName(source.getName());
        employeeDTO.setAddress(source.getAddress());
        employeeDTO.setSkype(source.getSkype());
        employeeDTO.setPhone(source.getPhone());
        employeeDTO.setMail(source.getMail());
        /*if (source.getDepartment() != null) {
            employeeDTO.setDepartment(getAsDepartmentDTO(source.getDepartment()));
        }*/
        return employeeDTO;
    }

    public static DepartmentDTO getAsDepartmentDTO(Department source) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(source.getId());
        departmentDTO.setName(source.getName());
        return departmentDTO;
    }

    public static Employee getAsEmployee(EmployeeDTO source) {
        Employee employee = new Employee();
        employee.setId(source.getId());
        employee.setName(source.getName());
        employee.setAddress(source.getAddress());
        employee.setSkype(source.getSkype());
        employee.setPhone(source.getPhone());
        employee.setMail(source.getMail());
        /*if (source.getDepartment() != null) {
            employee.setDepartment(getAsDepartment(source.getDepartment()));
        }*/
        return employee;
    }

    private static Department getAsDepartment(DepartmentDTO source) {
        Department department = new Department();
        department.setId(source.getId());
        department.setName(source.getName());
        return department;
    }
}