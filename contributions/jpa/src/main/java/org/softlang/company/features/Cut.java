package org.softlang.company.features;

import javax.persistence.EntityManager;

import org.softlang.company.model.Company;

public class Cut {

    public static void cut(EntityManager em, Company c) {
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
        // Cut is implemented in the Company class
        c.cut();
        em.getTransaction().commit();
    }

}