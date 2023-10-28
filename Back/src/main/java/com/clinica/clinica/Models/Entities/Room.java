package com.clinica.clinica.Models.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "habitacion")
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhabitacion")
    int id;

    @Column(name = "codigohabitacion")
    String roomCode;

    @Column(name = "cantidadpacientes")
    int maxPatient;

    @Column(name = "descripcion")
    String description;

    @Column(name = "idsucursal")
    int idBranch;

}
