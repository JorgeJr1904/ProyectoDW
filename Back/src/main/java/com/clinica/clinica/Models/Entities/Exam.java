package com.clinica.clinica.Models.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "examenes")
public class Exam {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idexamen")
    int id;

    @Column(name = "nombre")
    String name;

    @Column(name = "descripcion")
    String description;

}
