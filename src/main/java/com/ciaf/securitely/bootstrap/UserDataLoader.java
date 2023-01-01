package com.ciaf.securitely.bootstrap;

import com.ciaf.securitely.entities.security.Authority;
import com.ciaf.securitely.entities.security.Role;
import com.ciaf.securitely.entities.security.User;
import com.ciaf.securitely.repositories.security.AuthorityRepository;
import com.ciaf.securitely.repositories.security.RoleRepository;
import com.ciaf.securitely.repositories.security.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserDataLoader implements CommandLineRunner {

    private final  AuthorityRepository authorityRepository;

    private final RoleRepository roleRepository;
    private final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private void loadSecurityData() {
//        Authority admin = authorityRepository.save(Authority.builder().permission("ROLE_ADMIN").build());
//        Authority userRole = authorityRepository.save(Authority.builder().permission("ROLE_USER").build());
//        Authority customer = authorityRepository.save(Authority.builder().permission("ROLE_CUSTOMER").build());

        Authority createPerson = authorityRepository.save(Authority.builder().permission("person.read").build());
        Authority deletePerson = authorityRepository.save(Authority.builder().permission("person.delete").build());
        Authority readPerson = authorityRepository.save(Authority.builder().permission("person.read").build());

        Role adminRole = roleRepository.save(Role.builder().name("ADMIN").build());
        Role customerRole = roleRepository.save(Role.builder().name("CUSTOMER").build());
        Role userRole = roleRepository.save(Role.builder().name("USER").build());

        adminRole.setAuthorities(new HashSet<>(Set.of(createPerson, deletePerson, readPerson)));
        customerRole.setAuthorities(new HashSet<>(Set.of(readPerson)));

        roleRepository.saveAll(Arrays.asList(adminRole, customerRole, userRole));

        userRepository.save(User.builder()
                .username("gil")
                .password(passwordEncoder.encode("gr007879"))
                .role(adminRole)
                .build());

        userRepository.save(User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .role(userRole)
                .build());

        userRepository.save(User.builder()
                .username("scott")
                .password(passwordEncoder.encode("tiger"))
                .role(customerRole)
                .build());

        log.debug("Users loaded: "+ userRepository.count());
    }

    @Override
    public void run(String... args) throws Exception {
        if(authorityRepository.count() == 0){
            loadSecurityData();
        }
    }
}
