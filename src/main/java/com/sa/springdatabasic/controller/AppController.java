package com.sa.springdatabasic.controller;


import com.sa.springdatabasic.model.Person;
import com.sa.springdatabasic.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Validated
public class AppController {

    private final PersonRepository repository;

    public AppController(PersonRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/persons")
    ResponseEntity<Flux<Person>>  listAllPerson(){
       return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/persons/{id}")
    ResponseEntity<Mono<Person>> findAPerson(String id){
        return ResponseEntity.ok()
                .body(repository.findById(id));
    }

    @PostMapping("/persons/person")
    ResponseEntity<Mono<Person>> persistAPerson( @RequestBody @Valid Person person){
        System.out.println("Person Object for persistence::" + person );
      return   ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(person));
    }

    @PutMapping("/persons/person")
    Mono<ResponseEntity<Person>> updateAPerson( @RequestBody @Valid Person person){
        return     repository.findById(person.getId())
                    .flatMap(person1 -> repository.save(person))
                    .map(person1 -> ResponseEntity.status(HttpStatus.CREATED).body(person1));

    }

    @DeleteMapping("/persons")
    ResponseEntity<Mono<Void>> deleteAllPerson(){
        return     ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(repository.deleteAll());

    }

}
