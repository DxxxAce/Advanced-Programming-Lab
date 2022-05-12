package com.lab9;

import com.lab9.entities.City;
import com.lab9.entities.Continent;
import com.lab9.entities.Country;
import com.lab9.repositories.CityRepository;
import com.lab9.repositories.ContinentRepository;
import com.lab9.repositories.CountryRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        loadContinents();
        loadCountries();
        loadCities();
    }

    public static void testJPA() {

        ContinentRepository continentRepo = new ContinentRepository();

        Continent continent = new Continent();
        continent.setName("Europe");

        continentRepo.create(continent);

        Continent c = continentRepo.findByName("Europe");
        c.setName("Africa");
        continentRepo.persist(c);
    }

    public static void loadContinents() {

        List<Continent> continents = new ArrayList<>();

        continents.add(new Continent("Africa"));
        continents.add(new Continent("Antarctica"));
        continents.add(new Continent("Asia"));
        continents.add(new Continent("Australia"));
        continents.add(new Continent("Europe"));
        continents.add(new Continent("Central America"));
        continents.add(new Continent("North America"));
        continents.add(new Continent("South America"));

        ContinentRepository continentRepo = new ContinentRepository();

        for (Continent continent : continents) {

           continentRepo.create(continent);
        }
    }

    public static void loadCountries() {

        String line = "";
        String sep = ",";

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/resources/concap.csv"));

            CountryRepository countryRepo = new CountryRepository();

            while ((line = br.readLine()) != null) {

                String[] countryData = line.split(sep);
                Continent continent = (new ContinentRepository()).findByName(countryData[5]);
                Country country = new Country(countryData[0].replaceAll("'", " "),
                        continent.getId(), countryData[4]);

                countryRepo.create(country);
                Set<Country> countries = continent.getCountries();
                countries.add(country);
                continent.setCountries(countries);
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void loadCities() {

        String line = "";
        String sep = ",";

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/resources/concap.csv"));

            CityRepository cityRepo = new CityRepository();

            while ((line = br.readLine()) != null) {

                String[] cityData = line.split(sep);
                City city = new City(cityData[1].replaceAll("'", " "),
                        (new CityRepository()).findByName(cityData[0]).getId(), true,
                        Float.parseFloat(cityData[2]), Float.parseFloat(cityData[3]));

                cityRepo.create(city);
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }
}

