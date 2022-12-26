package com.ciaf.securitely.repositories.geral;

import com.ciaf.securitely.entities.geral.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonsRepositories extends JpaRepository<Persons, Long> {

    @Query(value = "SELECT * from persons where corporate =:corporate ", nativeQuery = true)
    Optional<Persons> findByNameNative(@Param("corporate") String corporate);

    @Query(value = "SELECT * from persons where cpf_cnpj =:cpf_cnpj", nativeQuery = true)
    Optional<Persons> findByCpfCnpj(@Param("cpf_cnpj") String cpf_cnpj);

    @Query(value = "SELECT * from persons where cpf_cnpj =:cpf_cnpj AND id =:id", nativeQuery = true)
    Optional<Persons> findByIdAndCpfCnpj(@Param("cpf_cnpj") String cpf_cnpj, @Param("id") Long id);
}
