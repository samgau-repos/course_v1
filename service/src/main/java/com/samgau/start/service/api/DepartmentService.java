package com.samgau.start.service.api;

import com.samgau.start.model.dto.DepartmentDTO;

import java.util.List;

/**
 * Created by Chingiskhan on 31.03.2017.
 */
public interface DepartmentService {

    /**
     * Finds DepartmentDTO by id
     * @param id - id of entity
     * @return the found entity instance or null if the entity does
     *         not exist
     * @throws IllegalArgumentException if the argument is
     *         is not a valid type for that entity's primary key or
     *         is null
     */
    DepartmentDTO findById(Long id);

    /**
     * Updates given entity in database
     * @param DepartmentDTO entity with new values
     * @throws IllegalArgumentException if instance is not an
     *         entity or is a removed entity
     */
    DepartmentDTO update(DepartmentDTO DepartmentDTO);

    /**
     * Creates given entity in database
     * @param DepartmentDTO entity to created in database
     * @return generated id of entity
     */
    Long create(DepartmentDTO DepartmentDTO);

    /**
     * Finds DepartmentDTO by name
     * @param name name of DepartmentDTO
     * @return DepartmentDTO
     * @throws javax.persistence.NoResultException if no DepartmentDTO
     *          was found
     */
    DepartmentDTO findByName(String name);

    List<DepartmentDTO> getAll();
}
