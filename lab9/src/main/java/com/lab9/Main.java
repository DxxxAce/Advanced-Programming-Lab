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

        String line = "";
        String sep = ",";

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/resources/concap.csv"));

            ContinentRepository continentRepo = new ContinentRepository();

            while ((line = br.readLine()) != null) {

                long start = System.currentTimeMillis();

                String[] continentData = line.split(sep);

                if (continentRepo.findByName(continentData[5]) == null) {

                    Continent continent = new Continent(continentData[5]);

                    continentRepo.create(continent);

                    long time = System.currentTimeMillis() - start;
                    System.out.println("Log time for continent " + continent.getName() + ": " + time + " ms.");
                }
            }
        }
        catch (IOException e) {

            e.printStackTrace();
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

                long start = System.currentTimeMillis();

                String[] countryData = line.split(sep);

                ContinentRepository continentRepo = new ContinentRepository();
                Continent continent = continentRepo.findByName(countryData[5]);

                if (countryRepo.findByName(countryData[0]) == null) {

                    Country country = new Country(countryData[0],
                            continent.getId(), countryData[4]);

                    countryRepo.create(country);

                    continent.getCountries().add(country);
                    continentRepo.persist(continent);

                    long time = System.currentTimeMillis() - start;
                    System.out.println("Log time for country " + country.getName() + ": " + time + " ms.");
                }

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

                long start = System.currentTimeMillis();

                String[] cityData = line.split(sep);

                CountryRepository countryRepo = new CountryRepository();
                Country country = countryRepo.findByName(cityData[0]);

                if (cityRepo.findByName(cityData[1]) == null) {

                    City city = new City(cityData[1],
                            country.getId(), true, Float.parseFloat(cityData[2]),
                            Float.parseFloat(cityData[3]));

                    cityRepo.create(city);

                    country.getCities().add(city);
                    countryRepo.persist(country);

                    long time = System.currentTimeMillis() - start;
                    System.out.println("Log time for city " + city.getName() + ": " + time + " ms.");
                }
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }
}

