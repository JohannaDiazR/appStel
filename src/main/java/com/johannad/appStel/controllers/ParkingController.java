package com.johannad.appStel.controllers;

import com.johannad.appStel.business.ParkingBusiness;
import com.johannad.appStel.dtos.ParkingDto;
import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.entity.News;
import com.johannad.appStel.entity.Parking;
import com.johannad.appStel.service.imp.ParkingImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/parking", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class ParkingController {
    @Autowired
    private ParkingBusiness parkingBusiness;
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllParking() throws Exception {
        Map<String,Object> res = new HashMap<>();
        List<ParkingDto> listParkingDto=this.parkingBusiness.findAll();
        res.put("status","success");
        res.put("data",listParkingDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createParking(@RequestBody ParkingDto parkingDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            ParkingDto createdParkingDto = parkingBusiness.create(parkingDto);
            res.put("status", "success");
            res.put("data", createdParkingDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateParking(@PathVariable int id, @RequestBody ParkingDto updatedParkingDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            parkingBusiness.update(updatedParkingDto, id);
            res.put("status", "success");
            res.put("data", updatedParkingDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteParking(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            parkingBusiness.delete(id);
            res.put("status", "success");
            res.put("message", "Parking deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
