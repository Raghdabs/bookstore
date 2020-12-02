package com.vermeg.ams.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.vermeg.ams.entities.Person;
import com.vermeg.ams.service.PersonService;

public class AppLoading implements ApplicationListener<ApplicationEvent> {

    @Autowired
    private PersonService personService;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        List<Person> personList = personService.getAllPersons();
        for(Person person: personList) {
            System.out.println(person.getName());
        }
    }

}
