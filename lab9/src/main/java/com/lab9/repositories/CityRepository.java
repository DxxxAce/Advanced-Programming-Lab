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

        try {

            return (City) em.createNamedQuery("City.findByName")
                    .setParameter("name", name)
                    .getSingleResult();
        }
        catch (Exception e) {

            return null;
        }
    }

    public List<City> findByCountry(Country country) {

        return em.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }

    public List<City> findByFirstLetter(char letter) {

        return em.createNamedQuery("City.findByFirstLetter")
                .setParameter("letter", letter)
                .getResultList();
    }

    public City findByPopulation(int population) {

        return (City) em.createNamedQuery("City.findByPopulation")
                .setParameter("population", population)
                .getSingleResult();
    }
}
