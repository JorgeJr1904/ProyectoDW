package com.clinica.clinica.Models.Entities.Login;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString @Getter @Setter @EqualsAndHashCode
@Table(name = "permissions")
public class Permissions {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpermission")
    int id;

    @Column(name = "idmodule")
    int idModule;

    @Column(name = "idrole")
    int idRole;
}
