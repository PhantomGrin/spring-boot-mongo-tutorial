package com.savindi.kuppispringmongo.controllers;

import com.savindi.kuppispringmongo.models.Person;
import com.savindi.kuppispringmongo.services.Personservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private Personservice personservice;

    @RequestMapping("/")
    public String hello(){
        return "Hello Welcome!";
    }

    @RequestMapping("/create")
    public String create(String fname, String lname, String course){
        Person person = personservice.create(fname, lname, course);
        return person.toString();
    }

    @RequestMapping("/get")
    public Person getPerson(@RequestParam String fname){
        return personservice.getByFirstName(fname);
    }

    @RequestMapping("/getAll")
    public List<Person> getAll(){
        return personservice.getAll();
    }

    @RequestMapping("/update")
    public String updatePerson(@RequestParam String fname,String lname, String course){
        return personservice.update(fname, lname, course).toString();
    }

    @RequestMapping("/delete")
    public String deletePerson(@RequestParam String fname){
        return personservice.deletePerson(fname);
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(){
        return personservice.deleteAll();
    }
}
