package com.lab11.service;

import com.lab11.model.Person;
import com.lab11.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService implements PersonServiceInferface {

    private final PersonRepo personRepo;

    @Override
    public List<Person> getPersons() {

        return personRepo.findAll();
    }

    @Override
    public void save(Person person) {

        personRepo.save(person);
    }

    @Override
    public boolean updatePerson(Long id, String name) {

        Optional<Person> person = personRepo.findById(id);

        if (person.isPresent()) {

            person.get().setName(name);
            personRepo.save(person.get());
            return true;
        }

        return false;
    }

    @Override
    public boolean deletePerson(Long id) {

        Optional<Person> person = personRepo.findById(id);

        if (person.isPresent()) {

            personRepo.delete(person.get());
            return true;
        }

        return false;
    }
}
