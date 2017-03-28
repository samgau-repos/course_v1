package com.samgau.start.service.dao;

import com.samgau.start.model.Department;

import javax.ejb.Local;

/**
 * Created by Chingiskhan on 24.03.2017.
 */
@Local
public interface DepartmentDAO {
    /**
     * Finds Department by id
     * @param id - id of entity
     * @return the found entity instance or null if the entity does
     *         not exist
     * @throws IllegalArgumentException if the argument is
     *         is not a valid type for that entity's primary key or
     *         is null
     */
    Department findById(Long id);

    /**
     * Updates given entity in database
     * @param Department entity with new values
     * @throws IllegalArgumentException if instance is not an
     *         entity or is a removed entity
     */
    Department update(Department Department);

    /**
     * Creates given entity in database
     * @param Department entity to created in database
     * @return generated id of entity
     */
    Long create(Department Department);

    /**
     * Finds Department by name
     * @param name name of Department
     * @return Department
     * @throws javax.persistence.NoResultException if no Department
     *          was found
     */
    Department findByName(String name);
}
