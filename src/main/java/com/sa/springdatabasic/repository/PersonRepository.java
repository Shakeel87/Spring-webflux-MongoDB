package com.sa.springdatabasic.repository;

import com.sa.springdatabasic.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonRepository extends ReactiveMongoRepository<Person,String> {
}
