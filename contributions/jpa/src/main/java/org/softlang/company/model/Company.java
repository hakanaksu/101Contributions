package org.softlang.company.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Department> depts = new LinkedList<Department>();
	
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

	public List<Department> getDepts() {
		return depts;
	}
	
	public Double total() {
		double total = 0;
		for (Department d : getDepts())
			total += d.total();
		return total;
	}	
	
	public void cut() {
		for (Department d : getDepts())
			d.cut();
	}	
}
