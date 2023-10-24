package com.clinica.clinica.Models.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString @Getter @Setter @EqualsAndHashCode
@Table(name = "puesto")
public class JobTitle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpuesto")
    int id;

    @Column(name = "nombre")
    String name;

    @Column(name = "descripcion")
    String description;

}
