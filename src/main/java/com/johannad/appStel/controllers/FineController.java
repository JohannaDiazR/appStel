package com.johannad.appStel.controllers;

import com.johannad.appStel.business.FineBusiness;
import com.johannad.appStel.dtos.FineDto;
import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.entity.Correspondence;
import com.johannad.appStel.entity.Fine;
import com.johannad.appStel.service.imp.FineImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/fine", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class FineController {

    @Autowired
    private FineBusiness fineBusiness;
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllFine() throws Exception {
        Map<String,Object> res = new HashMap<>();
        List<FineDto> listFineDto = this.fineBusiness.findAll();
        res.put("status","success");
        res.put("data",listFineDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createFine(@RequestBody FineDto fineDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            FineDto createdFineDto = fineBusiness.create(fineDto);
            res.put("status", "success");
            res.put("data", createdFineDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateFine(@PathVariable int id, @RequestBody FineDto updatedFineDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            fineBusiness.update(updatedFineDto, id);
            res.put("status", "success");
            res.put("data", updatedFineDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
