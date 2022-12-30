package com.ciaf.securitely;

import com.ciaf.securitely.entities.geral.Persons;
import com.ciaf.securitely.repositories.geral.PersonsRepositories;
import com.ciaf.securitely.services.PersonsServices;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestPropertySource("/application.properties")
@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase
class SecuritelyApplicationTests {
	Persons person;
	@Autowired
	PersonsServices services;
	@Autowired
	PersonsRepositories repositories;

	private boolean deleted = false;

	@BeforeEach
	 void addData(){
		person = new Persons(
				"Gilvan", "75417464600", "000000000", "Jovam", "Gil", "37718-106", "Rua Euzébio", "110", "ap 12",
				"Elvira", "35800000", "Caldas", "MG", "3530649193", "35984384286", "gilvan@ciaf.com.br", "1", "9", "55", "35");

		services.create(person);
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void createPersonService(){
		Persons confirmed = services.findByName("Jovam");
		assertEquals(person, confirmed);
	}

	@Test
	void deletePersons(){
		Optional<Persons> person = Optional.ofNullable(services.findByName("Jovam"));
		if (person.isPresent()){
			services.delete(person.get().getId());
			deleted = true;
		}
	}
	@AfterEach
	void deleteData(){
		Long id = person.getId();
		if(id != null && !deleted){
			services.delete(id);
		}
	}

}

