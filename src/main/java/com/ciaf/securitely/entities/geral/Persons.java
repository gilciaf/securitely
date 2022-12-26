package com.ciaf.securitely.entities.geral;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "persons")
public class Persons implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String cpf_cnpj;
    private String rg_insc_estadual;//informa sobre tipo de situação perante o estado 1 -contribuinte // 2-isento // 9
    private String corporate;
    private String nickname;
    private String cep;
    private String address;
    private String number;
    private String compl;
    private String district;
    private String c_mun;
    private String city;
    private String state;
    private String phonenumber;
    private String cellnumber;
    private String email;
    private String indfinal;
    private String ind_ie_dest;
    private String cod_pais;
    private String cod_uf;

}

