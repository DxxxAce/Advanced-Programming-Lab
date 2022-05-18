package com.lab9.solver;

import com.lab9.entities.City;
import com.lab9.repositories.CityRepository;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChocoSolver {

    public void result(int bound1, int bound2) {

        List<City> cities;

        for (char letter = 'A'; letter <= 'Z'; letter++) {

            Model model = new Model("Choco Solver");
            cities = new CityRepository().findByFirstLetter(letter);

            List<City> finalCities = cities;
            cities = cities.stream().filter(city -> {

                for (City tempCity : finalCities) {

                    if (city.getCountry() == tempCity.getCountry() && city.getName() != tempCity.getName()) {

                        return false;
                    }
                }

                return true;

            }).collect(Collectors.toList());

            if (!finalCities.isEmpty()) {

                int[] input = new int[finalCities.size()];

                for (int i = 0; i < input.length; i++) {

                    input[i] = finalCities.get(i).getPopulation();
                }

                IntVar [] populationCity = model.intVarArray(input.length, input);

                model.sum(populationCity, ">=", bound2).post();
                model.sum(populationCity, "<=", bound1).post();

                int count = 1;
                System.out.println(letter + ":");
                model.getSolver().solve();
                String [] result = Arrays.toString(model.getDomainUnion(populationCity))
                        .substring(1,Arrays.toString(model.getDomainUnion(populationCity)).length() - 1).split(", ");

                for (String res : result) {

                    System.out.print(new CityRepository().findByPopulation(Integer.parseInt(res)).getName() + "     ");
                }

                System.out.println();
                model.getSolver().setRestartOnSolutions();
            }
        }
    }
}
