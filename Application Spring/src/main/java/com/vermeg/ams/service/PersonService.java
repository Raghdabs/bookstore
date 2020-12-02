package com.vermeg.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vermeg.ams.entities.Person;

@Service
public class PersonService {

    public static List<Person> persons = new ArrayList<>();

    public void addPerson() {
        Person person = new Person();
        person.setId("1");
        person.setName("Dadang");
        person.setAddress("Jl. Pahlawan Seribu");
        persons.add(person);
    }

    public List<Person> getAllPersons() {
        return persons;
    }

}
