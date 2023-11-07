package com.clinica.clinica.Models.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "historial_paciente")
public class PatientHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhistorial")
    private int id;

    @Column(name = "diagnostico")
    private String diagnosis;

    @Column(name = "peso")
    private BigDecimal weight;

    @Column(name = "altura")
    private BigDecimal height;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private char status;

    @Column(name = "idpaciente")
    private long idPatient;
}
