package com.lab11.service;

import com.lab11.model.Person;

import java.util.List;

public interface Services {

    List<Person> get();

    void save(Person person);

    boolean update(Long id, String name);

    boolean delete(Long id);
}
