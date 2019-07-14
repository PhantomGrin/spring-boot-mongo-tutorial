package com.savindi.kuppispringmongo.services;

import com.savindi.kuppispringmongo.models.Person;
import com.savindi.kuppispringmongo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Personservice {

    @Autowired
    private PersonRepository personRepository;

//    Creat Operation
    public Person create(String fname, String lname, String course){
        return personRepository.save(new Person(fname, lname, course));
    }

//    Retrieve Operations
    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person getByFirstName(String fname){
        return personRepository.findByFname(fname);
    }

//    Update Operation
    public Person update(String fname, String lname, String course){
        Person person = personRepository.findByFname(fname);
        person.setLname(lname);
        person.setCourse(course);
        return personRepository.save(person);
    }

//    Delete Operations
    public String deleteAll(){
        personRepository.deleteAll();
        return "Successfully deleted all records";
    }

    public String deletePerson(String fname){
        Person person = personRepository.findByFname(fname);
        personRepository.delete(person);
        return "Successfully deleted" + fname;
    }
}

