package com.lab9.repositories;

import com.lab9.entities.Continent;
import com.lab9.entities.Country;

import java.util.List;

public class CountryRepository extends DataRepository {

    public  CountryRepository() { super(Country.class); }

    public List<Country> findAll() {

        return em.createNamedQuery("Country.findAll")
                .getResultList();
    }

    public Country findByName(String name) {

        return (Country) em.createNamedQuery("Country.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Country> findByContinent(Continent continent) {

        return em.createNamedQuery("Country.findByContinent")
                .setParameter("continent", continent)
                .getResultList();
    }
}
