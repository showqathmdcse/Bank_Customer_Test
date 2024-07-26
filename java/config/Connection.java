package com.java.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Cust" );
        EntityManager em = emf.createEntityManager();
        // em.getTransaction().begin();
        return em;
    }
}
