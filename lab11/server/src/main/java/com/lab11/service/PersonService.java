package com.lab11.service;

import com.lab11.model.Person;
import com.lab11.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {

    private final PersonRepository repo;

    public List<Person> get() {

        return repo.findAll();
    }

    public void save(Person person) {

        repo.save(person);
    }

    public boolean update(Long id, String name) {

        Optional<Person> person = repo.findById(id);

        if (person.isPresent()) {

            person.get().setName(name);
            repo.save(person.get());

            return true;
        }

        return false;
    }

    public boolean delete(Long id) {

        Optional<Person> person = repo.findById(id);

        if (person.isPresent()) {

            repo.delete(person.get());

            return true;
        }

        return false;
    }

    public List<Person> top()
    {
        return repo.findTop3ByOrderByTotalFriendsDesc();
    }
}
