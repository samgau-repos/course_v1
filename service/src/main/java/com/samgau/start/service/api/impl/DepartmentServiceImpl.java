package com.samgau.start.service.api.impl;

import com.samgau.start.common.util.TransferUtil;
import com.samgau.start.model.Department;
import com.samgau.start.model.dto.DepartmentDTO;
import com.samgau.start.service.api.DepartmentService;
import com.samgau.start.service.dao.DepartmentDAO;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chingiskhan on 31.03.2017.
 */
public class DepartmentServiceImpl implements DepartmentService{
    
    @EJB
    DepartmentDAO departmentDAO;
    
    @Override
    public DepartmentDTO findById(Long id) {
        Department result = departmentDAO.findById(id);
        if (result != null) {
            return TransferUtil.getAsDepartmentDTO(result);
        }
        return null;
    }

    @Override
    public DepartmentDTO update(DepartmentDTO source) {
        Department department = TransferUtil.getAsDepartment(source);
        department = departmentDAO.update(department);
        DepartmentDTO departmentDTO = TransferUtil.getAsDepartmentDTO(department);
        return departmentDTO;
    }

    @Override
    public Long create(DepartmentDTO source) {
        Department department = TransferUtil.getAsDepartment(source);
        return departmentDAO.create(department);
    }

    @Override
    public DepartmentDTO findByName(String name) {
        Department department = departmentDAO.findByName(name);
        if (department != null) {
            return TransferUtil.getAsDepartmentDTO(department);
        }
        return null;
    }

    @Override
    public List<DepartmentDTO> getAll() {
        List<DepartmentDTO> result = new ArrayList<>();
        List<Department> departmentList = departmentDAO.getAll();
        for (int i=0; i < departmentList.size(); i++) {
            DepartmentDTO employeeDTO = TransferUtil.getAsDepartmentDTO(departmentList.get(i));
            result.add(employeeDTO);
        }
        return result;
    }
    
}
