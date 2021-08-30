package com.assetclfmd.inventory.controller;

import com.assetclfmd.inventory.entity.Person;
import com.assetclfmd.inventory.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping("/addPerson")
    public Object addPerson(@RequestBody Person person) {
        return service.savePerson(person);
    }

    @PostMapping("/addPersons")
    public List<Person> addPerson(@RequestBody List<Person> person) {
        return service.savePersonList(person);
    }

    @GetMapping("/persons")
    public List findAllPerson(
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String> email,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> dob) {
        return service.getPersonList(name,email,dob);
    }

    @GetMapping("/personById/{id}")
    public Person findPersonById(@PathVariable int id) {
        return service.getPersonById(id);
    }

    @GetMapping("/personsName/{name}")
    public List<Person> findPersonByName(@PathVariable String name) {
        return service.getPersonByName(name);
    }
    @GetMapping("/personsDOB/{dob}")
    public List<Person> findPersonByDOB(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob) {
        return service.getPersonByDOB(dob);
    }

    @PutMapping("/updatePerson")
    public Person updatePerson(@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @DeleteMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable int id) {
        return service.deletePerson(id);
    }
}
