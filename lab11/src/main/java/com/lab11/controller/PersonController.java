package com.lab11.controller;

import com.lab11.model.Person;
import com.lab11.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/get")
    public List<Person> getPersons () {

        return personService.getPersons();
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePerson (@RequestBody Person person) {

        if (person==null) {

            return new ResponseEntity<>("Bad request",HttpStatus.BAD_REQUEST);
        }

        personService.save(person);
        return new ResponseEntity<>("Person created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestParam String name) {

        if (!personService.updatePerson(id,name)) {

            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {

        if (!personService.deletePerson(id)) {

            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
    }
}
