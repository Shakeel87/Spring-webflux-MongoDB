package com.sa.springdatabasic.repository;

import com.sa.springdatabasic.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;



public interface PersonRepository extends ReactiveMongoRepository<Person,String> {

    Flux<Person> findByAddress_zipCode(int zipCode);
}
