package com.clinica.clinica.Models.Dao.Login;

import com.clinica.clinica.Models.Entities.Login.Permission;
import com.clinica.clinica.Models.Entities.Login.Role;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RoleDao {

    @Autowired
    Message message;

    @Autowired
    PermissionDao permissionDao;

    @PersistenceContext
    EntityManager entityManager;

    public List<Role> listRoles(){
        return entityManager.createQuery("FROM Role").getResultList();
    }

    public Role getRole(int id){
        return entityManager.find(Role.class, id);
    }

    public Message createRole(Role role, List<Permission> permissions){
        Message message = new Message();
        try{
            if (noRepeatRole(role.getRoleName())){
                entityManager.persist(role);
                permissionDao.createPermissions(role.getIdRole(), permissions);
                return message.createMessage(201, "Creado Correctamente");
            }else {
                return message.createMessage(404, "Rol No valido o ya existente");
            }
        }catch (Exception e){
            return message.createMessage(505, "Error en el sevidor");
        }
    }

    public Message updateRole(int id, Role role){
        Message message = new Message();
        Role localRole = entityManager.find(Role.class, id);
        try{
            if (localRole.getRoleName().equals(role.getRoleName())){
                role.setIdRole(id);
                entityManager.merge(role);
                return message.createMessage(200, "Actualizado Correctamente");
            }else if (noRepeatRole(role.getRoleName())){
                role.setIdRole(id);
                entityManager.merge(role);
                return message.createMessage(200, "Actualizado Correctamente");
            }else{
                return message.createMessage(404, "Rol No valido o ya existe");
            }
        }catch (Exception e){
            return message.createMessage(500, "Error en el Servidor");
        }
    }

    public Message deleteRole(int id){
        try{
            Role role = entityManager.find(Role.class, id);
            entityManager.remove(role);
            return message.createMessage(204, "Paciente Eliminado Correctamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return message.createMessage(500, "Error al eliminar paciente");
        }
    }

    //Termina CRUD ------------------------------------------------------------------------------------------------------------------------------

    private boolean noRepeatRole(String name){
        String sql = "SELECT COUNT(e) FROM Role e WHERE e.roleName = :roleName";
        Long count = entityManager.createQuery(sql, Long.class)
                .setParameter("roleName", name)
                .getSingleResult();
        return count < 1;
    }
}
