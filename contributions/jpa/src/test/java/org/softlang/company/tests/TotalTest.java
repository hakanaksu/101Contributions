package org.softlang.company.tests;

import org.softlang.company.model.Company;

import static org.softlang.company.features.Total.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.softlang.company.features.Persistence.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class TotalTest {

    @Test
    public void testTotal() {
		EntityManagerFactory emFactory = javax.persistence.Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emFactory.createEntityManager();
		createSampleCompany(em);
        Company c = loadCompany(em, "ACME Corporation");
        double total = total(c);		
        assertEquals(399747, total, 0);
        removeCompany(em, c);
    }

}