package main.com.samgau.start.service.api;

import com.samgau.start.model.dto.EmployeeDTO;

import javax.ejb.Local;

@Local
public interface EmployeeService {

    /**
     * Finds employee by id
     * @param id - id of entity
     * @return the found entity instance or null if the entity does
     *         not exist
     * @throws IllegalArgumentException if the argument is
     *         is not a valid type for that entity's primary key or
     *         is null
     */
    EmployeeDTO findById(Long id);

    /**
     * Updates given entity in database
     * @param employee entity with new values
     * @throws IllegalArgumentException if instance is not an
     *         entity or is a removed entity
     */
    EmployeeDTO update(EmployeeDTO employee);

    /**
     * Creates given entity in database
     * @param employee entity to created in database
     * @return generated id of entity
     */
    Long create(EmployeeDTO employee);

    /**
     * Finds employee by name
     * @param name name of employee
     * @return employee
     * @throws javax.persistence.NoResultException if no employee
     *          was found
     */
    EmployeeDTO findByName(String name);

}