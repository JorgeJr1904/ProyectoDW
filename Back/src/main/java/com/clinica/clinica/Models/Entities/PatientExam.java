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
@Table(name = "examen_paciente")
public class PatientExam {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idexamenpaciente" )
    int id;

    @Column(name = "idhistorial")
    int historyId;

    @Column(name = "idexamen")
    int examId;
}
