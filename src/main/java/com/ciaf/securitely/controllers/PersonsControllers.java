package com.ciaf.securitely.controllers;

import com.ciaf.securitely.entities.geral.Persons;
import com.ciaf.securitely.services.PersonsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping({ "/persons" })
public class PersonsControllers {
    @Autowired
    private PersonsServices services;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Persons>> findAll() {
        List<Persons> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Persons list = services.findById(id);
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin
    @GetMapping(path = {"/name/{corporate}"})
    public ResponseEntity<?> findByName(@PathVariable("corporate") String corporate) {
        Persons list = services.findByName(corporate);
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin
    @GetMapping(path = {"/cpfcnpf/{cpf_cnpj}"})
    public ResponseEntity<?> findByCpfCnpj(@PathVariable("cpf_cnpj") String cpf_cnpj) {
        Persons list = services.findByCpfOrCnpj(cpf_cnpj);
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Persons> create(@RequestBody Persons person) {
        person = services.create(person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).body(person);
    }

    @CrossOrigin
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Persons> update(@RequestBody Persons person, @PathVariable Long id) {
        person = services.update(id, person);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    public ResponseEntity<Persons> updatePatch(@RequestBody Persons person, @PathVariable Long id) {
        person = services.update(id, person);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();

    }
}
