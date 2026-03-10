package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")  
public class PersonController {
   
    @Autowired
    private PersonServices service;

    @GetMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll() { 
        return service.findAll();
    }

    @GetMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @NonNull Person findById(@PathVariable("id") @NonNull Long id) { 
        return service.findById(id);
    }

    @PostMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE, 
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public @NonNull Person create(@RequestBody @NonNull Person person) { 
        return service.create(person);
    }

    @PutMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE, 
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public @NonNull Person update(@RequestBody @NonNull Person person) { 
        return service.update(person);
    }

    @DeleteMapping(
        value = "/{id}"
    )
    public ResponseEntity<?> delete(@PathVariable("id") @NonNull Long id) { 
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
