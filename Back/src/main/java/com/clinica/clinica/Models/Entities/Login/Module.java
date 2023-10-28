package com.clinica.clinica.Models.Entities.Login;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter @EqualsAndHashCode
@Table(name = "modules")
public class Module {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmodule")
    int idModule;

    @Column(name = "modulename")
    String moduleName;

}
