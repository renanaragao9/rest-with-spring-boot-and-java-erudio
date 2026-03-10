package br.com.erudio.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;


    public @NonNull List<Person> findAll() {
        return repository.findAll();
    }

    public @NonNull Person findById(@NonNull Long id) {
       return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public @NonNull Person create(@NonNull Person person) {
        return repository.save(person);
    }

    public @NonNull Person update(@NonNull Person person) {
        Long id = Objects.requireNonNull(person.getId(), "Person id cannot be null");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    @SuppressWarnings("null")
    public void delete(@NonNull Long id) {
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        repository.delete(entity);
    }
}
