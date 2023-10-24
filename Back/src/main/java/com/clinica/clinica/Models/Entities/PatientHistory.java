package com.clinica.clinica.Models.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "historial_paciente")
public class PatientHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhistorial")
    int id;

    @Column(name = "diagnostico")
    String diagnosis;

    @Column(name = "descripcion")
    String description;

    @Column(name = "estado")
    char status;

    @Column(name = "idpaciente")
    long idPatient;
}
