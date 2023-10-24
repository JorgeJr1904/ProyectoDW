package com.clinica.clinica.Models.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "medicamento")
public class Medicine {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedicamento")
    int id;

    @Column(name = "codigo")
    String code;

    @Column(name = "nombre")
    String name;

    @Column(name = "descripcion")
    String description;

    @Column(name = "precio")
    BigDecimal price;

    @Column(name = "cantidad")
    int quantity;

    @Column(name = "vpath")
    String imagePath;

    @Column(name = "idsucursal")
    int BranchId;

}
