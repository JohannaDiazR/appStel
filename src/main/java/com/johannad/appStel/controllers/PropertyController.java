package com.johannad.appStel.controllers;


import com.johannad.appStel.business.PropertyBusiness;
import com.johannad.appStel.dtos.PropertyDto;
import com.johannad.appStel.dtos.WorkerDto;
import com.johannad.appStel.entity.Parking;
import com.johannad.appStel.entity.Property;
import com.johannad.appStel.service.imp.PropertyImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/property", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class PropertyController {
    @Autowired
    private PropertyBusiness propertyBusiness;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllProperty() throws Exception {
        Map<String, Object> res = new HashMap<>();
        List<PropertyDto> listPropertyDto = this.propertyBusiness.findAll();
        res.put("status", "success");
        res.put("data", listPropertyDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createProperty(@RequestBody PropertyDto propertyDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            PropertyDto createdPropertyDto = propertyBusiness.create(propertyDto);
            res.put("status", "success");
            res.put("data", createdPropertyDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateProperty(@PathVariable int id, @RequestBody PropertyDto updatedPropertyDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            propertyBusiness.update(updatedPropertyDto, id);
            res.put("status", "success");
            res.put("data", updatedPropertyDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
