package com.clinica.clinica.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sucursal")
@Getter @Setter @EqualsAndHashCode @ToString
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsucursal")
    int id;

    @Column(name = "codigo")
    String code;

    @Column(name = "nombre")
    String branchName;

    @Column(name = "direccion")
    String address;

    @Column(name = "telefono")
    String tel;
}