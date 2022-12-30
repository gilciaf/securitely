package com.ciaf.securitely;

import com.ciaf.securitely.entities.geral.Persons;
import com.ciaf.securitely.services.PersonsServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestPropertySource("/application.properties")
//@AutoConfigureMockMvc
@SpringBootTest
public class RestApiTests {

    Persons person;
    @Autowired
    PersonsServices services;

    @Autowired
    private WebApplicationContext wac;

    //    @Autowired
    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
        person = new Persons(
                "Gilvan", "75417464600", "000000000", "Jovam", "Gil", "37718-106", "Rua Euzébio", "110", "ap 12",
                "Elvira", "35800000", "Caldas", "MG", "3530649193", "35984384286", "gilvan@ciaf.com.br", "1", "9", "55", "35");

        services.create(person);
    }

    @Test
    void getPersons() throws Exception {
        mockMvc.perform(get("/persons")
                        .with(httpBasic("gil", "gr007879")))
                .andExpect(status().is2xxSuccessful());

    }
    @Test
    void getPersonsFail() throws Exception {
        mockMvc.perform(get("/persons")
                        .with(httpBasic("user", "password")))
                .andExpect(status().isForbidden());

    }
    @Test
    void getPersonsNoLoggin() throws Exception {
        mockMvc.perform(get("/persons"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void deletePersonsHttpBasicUserRole() throws Exception {
        Long id = person.getId();
        mockMvc.perform(delete("/persons/" + id)
                        .with(httpBasic("gil", "gr007879")))
                .andExpect(status().is2xxSuccessful());
    }
}
