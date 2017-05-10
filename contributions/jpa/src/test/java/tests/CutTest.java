package org.softlang.company.tests;

import org.softlang.company.model.Company;

import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Persistence.createSampleCompany;
import static org.softlang.company.features.Persistence.loadCompany;
import static org.softlang.company.features.Total.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.softlang.company.features.Persistence.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class CutTest {

    @Test
    public void testCut() {
		EntityManagerFactory emFactory = javax.persistence.Persistence.createEntityManagerFactory("jpa");
		EntityManager em = emFactory.createEntityManager();
		createSampleCompany(em);
        Company c = loadCompany(em, 0);
        cut(em, c);
        double total = total(c);		
        assertEquals(399747 / 2.0d, total, 0);
        removeCompany(em,c);
    }

}