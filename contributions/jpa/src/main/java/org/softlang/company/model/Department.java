package org.softlang.company.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Employee manager;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Department> subdepts = new LinkedList<Department>();
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Employee> employees = new LinkedList<Employee>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Department> getSubdepts() {
		return subdepts;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	public double total() {
		double total = 0;
		total += getManager().getSalary();
		for (Department s : getSubdepts())
			total += s.total();
		for (Employee e : getEmployees())
			total += e.getSalary();
		return total;		
	}	
	
	public void cut() {
		getManager().cut();
		for (Department s : getSubdepts())
			s.cut();
		for (Employee e : getEmployees())
			e.cut();
	}	
}
