package main.com.samgau.start.service.api.impl;

import com.samgau.start.common.util.TransferUtil;
import com.samgau.start.model.Employee;
import com.samgau.start.model.dao.EmployeeDAO;
import com.samgau.start.model.dto.EmployeeDTO;
import main.com.samgau.start.service.api.EmployeeService;

import javax.ejb.EJB;

/**
 * Created by Chingiskhan on 24.03.2017.
 */
public class EmployeeServiceImpl implements EmployeeService{

    @EJB
    EmployeeDAO employeeDAO;

    @Override
    public EmployeeDTO findById(Long id) {
        Employee result = employeeDAO.findById(id);
        if (result != null) {
            return TransferUtil.getAsEmployeeDTO(result);
        }
        return null;
    }

    @Override
    public EmployeeDTO update(EmployeeDTO source) {
        Employee employee = TransferUtil.getAsEmployee(source);
        employee = employeeDAO.update(employee);
        EmployeeDTO employeeDTO = TransferUtil.getAsEmployeeDTO(employee);
        return employeeDTO;
    }

    @Override
    public Long create(EmployeeDTO source) {
        Employee employee = TransferUtil.getAsEmployee(source);
        return employeeDAO.create(employee);
    }

    @Override
    public EmployeeDTO findByName(String name) {
        Employee employee = employeeDAO.findByName(name);
        if (employee != null) {
            return TransferUtil.getAsEmployeeDTO(employee);
        }
        return null;
    }

}
