package com.johannad.appStel.controllers;

import com.johannad.appStel.business.RateBusiness;
import com.johannad.appStel.dtos.RateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/rate", method = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST} )
@CrossOrigin("*")
public class RateController {

    @Autowired
    private RateBusiness rateBusiness;
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllRate(){
        Map<String,Object> res = new HashMap<>();
        try {
            List<RateDto> listRateDto=this.rateBusiness.findAll();
            res.put("status","success");
            res.put("data",listRateDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e){
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createRate(@RequestBody RateDto rateDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            RateDto createdRateDto = rateBusiness.create(rateDto);
            res.put("status", "success");
            res.put("data", createdRateDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateRate(@PathVariable int id, @RequestBody RateDto updatedRateDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            rateBusiness.update(updatedRateDto, id);
            res.put("status", "success");
            res.put("data", updatedRateDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteRate(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            rateBusiness.delete(id);
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
