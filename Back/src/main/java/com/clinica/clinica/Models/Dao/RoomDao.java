package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.PatientHistory;
import com.clinica.clinica.Models.Entities.Room;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RoomDao {

    @Autowired
    Message message;

    @PersistenceContext
    EntityManager entityManager;

    public List<Room> getRoom() {
        return entityManager.createQuery("FROM Room").getResultList();
    }

    public Room getRoom(int id) {
        try {
            Room room = entityManager.find(Room.class, id);
            return room;
        } catch (Exception e) {
            return null;
        }
    }

    public Message createRoom(Room room) {
        try {
            if(entityManager.find(Room.class, room.getRoomCode()) != null){
                return message.createMessage(404, "Codigo de habitacion ya existe ");
            }
            entityManager.persist(room);
            return message.createMessage(200, "Creado Exitosamente");
        } catch (Exception ex) {
            return message.createMessage(500, "Error de Servidor");
        }
    }

    public Message updateRoom(Room room, int id) {
        try {
            Room room1 = entityManager.find(Room.class, id);
            if (room1 != null) {
                entityManager.merge(room1);
                return message.createMessage(200, "Actualizado Correctamente");
            } else {
                return message.createMessage(404, "no existe");
            }
        } catch (Exception e) {
            return message.createMessage(500, "Error en el servidor");
        }
    }

    public Message deleteRoom(int id) {
        try {
            Room room1 = entityManager.find(Room.class, id);
            if (room1 != null) {
                entityManager.remove(room1);
                return message.createMessage(200, "Borrado Correctamente");
            } else {
                return message.createMessage(404, "No existe");
            }
        } catch (Exception e) {
            return message.createMessage(500, "Error en el servidor");
        }
    }

    private boolean noRepeatRoom(String name){
        String sql = "SELECT COUNT(e) FROM Room e WHERE e.roomCode = :room";
        Long count = entityManager.createQuery(sql, Long.class)
                .setParameter("room", name)
                .getSingleResult();
        return count < 1;
    }
}
