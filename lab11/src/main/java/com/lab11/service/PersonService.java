package com.lab11.service;

import com.lab11.model.Person;
import com.lab11.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService implements Services {

    private final PersonRepository repo;

    @Override
    public List<Person> get() {

        return repo.findAll();
    }

    @Override
    public void save(Person person) {

        repo.save(person);
    }

    @Override
    public boolean update(Long id, String name) {

        Optional<Person> person = repo.findById(id);

        if (person.isPresent()) {

            person.get().setName(name);
            repo.save(person.get());

            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Long id) {

        Optional<Person> person = repo.findById(id);

        if (person.isPresent()) {

            repo.delete(person.get());

            return true;
        }

        return false;
    }
}
