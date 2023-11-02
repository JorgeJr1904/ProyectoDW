package com.clinica.clinica.Dto;

import com.clinica.clinica.Models.Entities.Login.Permission;
import com.clinica.clinica.Models.Entities.Login.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class PermissionsDto {

    Role role;
    List<Permission> permission;
}
