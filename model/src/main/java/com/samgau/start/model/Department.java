package com.samgau.start.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tolegen Izbassar on 17.03.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Department.FindByName", query = "" +
                "SELECT dep from Department dep where dep.name = :p_name"),
        @NamedQuery(name = "Department.FindAll", query = "SELECT dep from Department dep"),
})
@Table(name = "D_DEPARTMENT")
public class Department implements Serializable, Comparable<Department> {

	private Long id;
	private String name;

	private static final long serialVersionUID = 7854472633800183953L;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public int compareTo(Department o) {
        return getName().compareTo(o.getName());
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Department)) {
			return false;
		}
		Department other = (Department) obj;
		if (getId() != null) {
			if (!getId().equals(other.getId())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}
}
