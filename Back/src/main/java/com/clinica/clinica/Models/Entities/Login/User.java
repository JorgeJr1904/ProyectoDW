package com.clinica.clinica.Models.Entities.Login;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "user_info")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    int id;

    @Column(name = "username")
    String username;

    @Column(name = "vpassword")
    String password;

    @Column(name = "idrole")
    int idRole;

    @Column(name = "idsucursal")
    int branchId;
}
