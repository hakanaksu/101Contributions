package org.softlang.company.features;

import javax.persistence.EntityManager;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class Persistence {

	private EntityManager em;

	
	public static void createSampleCompany(EntityManager em){
		// Create company
        Company sampleCompany = new Company();
        sampleCompany.setName("ACME Corporation");
        
        // Create all employees
        Employee craig = new Employee();
        craig.setName("Craig");
        craig.setAddress("Redmond");
        craig.setSalary(123456);
        Employee erik = new Employee();
        erik.setName("Erik");
        erik.setAddress("Utrecht");
        erik.setSalary(12345);
        Employee ralf = new Employee();
        ralf.setName("Ralf");
        ralf.setAddress("Koblenz");
        ralf.setSalary(1234);
        Employee ray = new Employee();
        ray.setName("Ray");
        ray.setAddress("Redmond");
        ray.setSalary(234567);
        Employee klaus = new Employee();
        klaus.setName("Klaus");
        klaus.setAddress("Boston");
        klaus.setSalary(23456);
        Employee karl = new Employee();
        karl.setName("Karl");
        karl.setAddress("Riga");
        karl.setSalary(2345);
        Employee joe = new Employee();
        joe.setName("Joe");
        joe.setAddress("Wifi City");
        joe.setSalary(2344);

        // Create research department
        Department research = new Department();
        research.setManager(craig);
        research.setName("Research");
        research.getEmployees().add(erik);
        research.getEmployees().add(ralf);
        sampleCompany.getDepts().add(research);

        // Create development department
        Department development = new Department();
        development.setManager(ray);
        development.setName("Development");
        sampleCompany.getDepts().add(development);

        // Create sub-department dev1
        Department dev1 = new Department();
        dev1.setName("Dev1");
        dev1.setManager(klaus);
        development.getSubdepts().add(dev1);

        // Create sub-department dev11
        Department dev11 = new Department();
        dev11.setName("Dev1.1");
        dev11.setManager(karl);
        dev11.getEmployees().add(joe);
        dev1.getSubdepts().add(dev11);
		
        persistCompany(em, sampleCompany);

	}
	
	public static void persistCompany(EntityManager em, Company c){
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}

	public static Company loadCompany(EntityManager em, String name) {
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		Company c = 
				(Company) em.createQuery("Select c from Company c where c.name = :name ", Company.class)
				.setParameter("name", name)
				.getSingleResult();
		return c;
	}
	
	public static void removeCompany(EntityManager em, Company c) {
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}
}
