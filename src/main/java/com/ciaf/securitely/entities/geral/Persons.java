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

    public Persons(String name, String cpf_cnpj, String rg_insc_estadual, String corporate, String nickname, String cep, String address, String number, String compl, String district, String c_mun, String city, String state, String phonenumber, String cellnumber, String email, String indfinal, String ind_ie_dest, String cod_pais, String cod_uf) {
        this.name = name;
        this.cpf_cnpj = cpf_cnpj;
        this.rg_insc_estadual = rg_insc_estadual;
        this.corporate = corporate;
        this.nickname = nickname;
        this.cep = cep;
        this.address = address;
        this.number = number;
        this.compl = compl;
        this.district = district;
        this.c_mun = c_mun;
        this.city = city;
        this.state = state;
        this.phonenumber = phonenumber;
        this.cellnumber = cellnumber;
        this.email = email;
        this.indfinal = indfinal;
        this.ind_ie_dest = ind_ie_dest;
        this.cod_pais = cod_pais;
        this.cod_uf = cod_uf;
    }
}

