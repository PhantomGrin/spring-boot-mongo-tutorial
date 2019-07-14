package com.savindi.kuppispringmongo.repositories;

import com.savindi.kuppispringmongo.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    public Person findByFname(String fname);
}
