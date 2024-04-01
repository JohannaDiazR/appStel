package com.johannad.appStel.controllers;
import com.johannad.appStel.business.ResidentBusiness;
import com.johannad.appStel.dtos.ResidentDto;
import com.johannad.appStel.dtos.UserDto;
import com.johannad.appStel.dtos.VisitorDto;
import com.johannad.appStel.entity.Property;
import com.johannad.appStel.entity.Role;
import com.johannad.appStel.service.imp.ResidentImp;
import com.johannad.appStel.entity.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/resident", method = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST} )
@CrossOrigin("*")
public class ResidentController {
    @Autowired
    private ResidentBusiness residentBusiness;
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllResident() throws Exception {
        Map<String,Object> res = new HashMap<>();
        List<ResidentDto> listResidentDto=this.residentBusiness.findAll();
        res.put("status","success");
        res.put("data",listResidentDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createResident(@RequestBody ResidentDto residentDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            ResidentDto createdResidentDto = residentBusiness.create(residentDto);
            res.put("status", "success");
            res.put("data", createdResidentDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateResident(@PathVariable int id, @RequestBody ResidentDto updatedResidentDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            residentBusiness.update(updatedResidentDto, id);
            res.put("status", "success");
            res.put("data", updatedResidentDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteResident(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            residentBusiness.delete(id);
            res.put("status", "success");
            res.put("message", "Resident deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
