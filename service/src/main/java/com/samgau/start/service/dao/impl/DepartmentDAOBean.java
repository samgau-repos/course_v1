package com.samgau.start.service.dao.impl;

import com.samgau.start.model.Department;
import com.samgau.start.service.dao.DepartmentDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Chingiskhan on 24.03.2017.
 */
@Stateless
public class DepartmentDAOBean implements DepartmentDAO{
    @PersistenceContext(unitName = "model-persistence-unit")
    EntityManager entityManager;

    @Override
    public Department findById(Long id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public Department update(Department Department) {
        return entityManager.merge(Department);
    }

    @Override
    public Long create(Department Department) {
        entityManager.persist(Department);
        return Department.getId();
    }

    @Override
    public Department findByName(String name) {
        TypedQuery<Department> query = entityManager
                .createNamedQuery("Department.FindByName", Department.class);
        query.setParameter("p_name", name);
        return query.getSingleResult();
    }

    @Override
    public List<Department> getAll() {
        return entityManager
                .createNamedQuery("Department.FindAll", Department.class)
                .getResultList();
    }

}
