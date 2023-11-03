package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.PatientHistoryDao;
import com.clinica.clinica.Models.Dao.RoomDao;
import com.clinica.clinica.Models.Entities.PatientHistory;
import com.clinica.clinica.Models.Entities.Room;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/room")
public class RoomController {

    @Autowired
    RoomDao roomDao;

    @GetMapping()
    public List<Room> getRoom(){
        return roomDao.getRoom();
    }

    @GetMapping("{id}")
    public Room getRoom(@PathVariable int id){
        return roomDao.getRoom(id);
    }

    @PostMapping("post")
    public Message createRoom(@RequestBody Room room){
        return roomDao.createRoom(room);
    }

    @PutMapping("update/{id}")
    public Message updateRoom(@RequestBody Room room, @PathVariable int id){
        return roomDao.updateRoom(room, id);
    }

    @DeleteMapping("delete/{id}")
    public Message deleteRoom(@PathVariable int id){
        return roomDao.deleteRoom(id);
    }

}
