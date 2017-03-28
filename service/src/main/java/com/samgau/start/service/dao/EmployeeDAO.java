package com.samgau.start.service.dao;

import com.samgau.start.model.Employee;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Tolegen Izbassar on 17.03.2017.
 */
@Local
public interface EmployeeDAO {

    /**
     * Finds employee by id
     * @param id - id of entity
     * @return the found entity instance or null if the entity does
     *         not exist
     * @throws IllegalArgumentException if the argument is
     *         is not a valid type for that entity's primary key or
     *         is null
     */
    Employee findById(Long id);

    /**
     * Updates given entity in database
     * @param employee entity with new values
     * @throws IllegalArgumentException if instance is not an
     *         entity or is a removed entity
     */
    Employee update(Employee employee);

    /**
     * Creates given entity in database
     * @param employee entity to created in database
     * @return generated id of entity
     */
    Long create(Employee employee);

    /**
     * Finds employee by name
     * @param name name of employee
     * @return employee
     * @throws javax.persistence.NoResultException if no employee
     *          was found
     */
    Employee findByName(String name);

    List<Employee> getAll();
}
