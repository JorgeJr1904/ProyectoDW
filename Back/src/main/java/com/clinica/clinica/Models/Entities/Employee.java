package com.clinica.clinica.Models.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "empleado")
public class Employee {

    @Id
    @Column(name = "id")
    long id;

    @Column(name = "nombres")
    String name;

    @Column(name = "apellidos")
    String lastname;

    @Column(name = "telefono")
    String tel;

    @Column(name = "direccion")
    String address;

    @Column(name = "correo")
    String email;

    @Column(name = "tipo_sangre")
    String blood;

    @Column(name = "fechanacimiento")
    Date birthday;

    @Column(name = "sexo")
    String sex;

    @Column(name = "idpuesto")
    int JobTitleId;
}
