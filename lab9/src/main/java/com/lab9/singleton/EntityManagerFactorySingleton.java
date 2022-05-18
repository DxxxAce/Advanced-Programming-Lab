package com.lab9.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory emf = null;

    public EntityManagerFactorySingleton() { }

    public static EntityManagerFactory getEntityManagerFactory() {

        if (emf == null || !emf.isOpen()) {

            createEntityManagerFactory();
        }

        return emf;
    }

    private static void createEntityManagerFactory() {

        emf = Persistence.createEntityManagerFactory("default");
    }

    private static void closeEntityManagerFactory() {

        emf.close();
    }
}
