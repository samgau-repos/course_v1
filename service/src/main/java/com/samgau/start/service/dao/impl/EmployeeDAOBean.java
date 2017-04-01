package com.samgau.start.service.dao.impl;

import com.samgau.start.model.Employee;
import com.samgau.start.service.dao.EmployeeDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Tolegen Izbassar on 17.03.2017.
 */
@Stateless
public class EmployeeDAOBean implements EmployeeDAO {

    @PersistenceContext(unitName = "model-persistence-unit")
    private EntityManager entityManager;

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee update(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Long create(Employee employee) {
        entityManager.persist(employee);
        return employee.getId();
    }

    @Override
    public Employee findByName(String name) {
        TypedQuery<Employee> query = entityManager
                .createNamedQuery("Employee.FindByName", Employee.class);
        query.setParameter("p_name", name);
        return query.getSingleResult();
    }

    @Override
    public List<Employee> getAll() {
        return entityManager
                .createNamedQuery("Employee.FindAll", Employee.class)
                .getResultList();
    }

    @Override
    public void removeEmployee(Employee employee) {
        employee.setIsRemoved(1);
        this.update(employee);
    }

}
