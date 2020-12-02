package com.vermeg.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.ams.entities.Person;
import com.vermeg.ams.service.PersonService;

@RestController
@RequestMapping(value = "api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "persons")
    public List<Person> findAll() {
        personService.addPerson();
        return personService.getAllPersons();
    }

}
