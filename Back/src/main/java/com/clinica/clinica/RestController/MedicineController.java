package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.MedicineDao;
import com.clinica.clinica.Models.Dao.PatientDao;
import com.clinica.clinica.Models.Entities.Medicine;
import com.clinica.clinica.Models.Entities.Patients;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/medicine")
public class MedicineController {


    @Autowired
    private MedicineDao medicineDao;

    @GetMapping()
    public List<Medicine> getPatientList(){
        return medicineDao.listMedicine();
    }

    @GetMapping("{id}")
    public Medicine getMedicine(@PathVariable int id){
        return medicineDao.getMedicine(id);
    }

    @GetMapping("search/{search}")
    public List<Medicine> searchMedicine(@PathVariable String search){
        return medicineDao.searchMedicine(search);
    }

    @PostMapping("post")
    public Message createMedicine(@RequestBody Medicine medicine){
        return medicineDao.createMedicine(medicine);
    }

    @PutMapping("update/{id}")
    public Message updateMedicine(@PathVariable int id, @RequestBody Medicine medicine){
        return medicineDao.updateMedicine(id, medicine);
    }

    @DeleteMapping("delete/{id}")
    public Message deleteMedicine(@PathVariable int id){
        return medicineDao.deleteMedicine(id);
    }


}
