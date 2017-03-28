package com.samgau.start.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tolegen Izbassar on 15.03.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.FindAll", query = "" +
                "SELECT emp from Employee emp"),
        @NamedQuery(name = "Employee.FindByName", query = "" +
                "SELECT emp from Employee emp where emp.name = :p_name")
})
@Table(name = "E_EMPLOYEE")
public class Employee implements Comparable<Employee>, Serializable {

	private Long id;
	private String name;
	private String skype;
	private String phone;
	private String mail;
	private String address;
	//private Department department;

	private static final long serialVersionUID = -6567636814130505329L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*
	@ManyToOne
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	*/

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Employee employee = (Employee) o;

		return getId() != null ? getId().equals(employee.getId()) : employee
				.getId() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	@Override
	public int compareTo(Employee o) {
		return this.getId().compareTo(o.getId());
	}
}
