package com.lab9.repositories;

import com.lab9.entities.Continent;

import java.util.List;

public class ContinentRepository extends DataRepository {

    public  ContinentRepository() { super(Continent.class); }

    public List<Continent> findAll() {

        return em.createNamedQuery("Continent.findAll")
                .getResultList();
    }

    public Continent findByName(String name) {

        try {

            return (Continent) em.createNamedQuery("Continent.findByName")
                    .setParameter("name", name)
                    .getSingleResult();
        }
        catch (Exception e) {

            return null;
        }
    }
}
