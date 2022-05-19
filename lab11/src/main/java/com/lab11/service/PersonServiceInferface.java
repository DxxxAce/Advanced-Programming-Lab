package com.lab11.service;


import com.lab11.model.Person;

import java.util.List;

public interface PersonServiceInferface {

    List<Person> getPersons();
    void save (Person person);
    boolean updatePerson(Long id, String name);
    boolean deletePerson(Long id);
}
