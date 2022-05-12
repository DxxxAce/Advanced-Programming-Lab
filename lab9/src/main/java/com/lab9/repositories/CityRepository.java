package com.lab9.repositories;

import com.lab9.entities.City;
import com.lab9.entities.Country;

import java.util.List;

public class CityRepository extends DataRepository {

    public  CityRepository() { super(City.class); }

    public List<City> findAll() {

        return em.createNamedQuery("City.findAll")
                .getResultList();
    }

    public City findByName(String name) {

        return (City) em.createNamedQuery("City.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<City> findByCountry(Country country) {

        return em.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }
}
