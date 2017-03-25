package com.samgau.start.model.dao.impl;

import com.samgau.start.model.Department;
import com.samgau.start.model.dao.DepartmentDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    
}
