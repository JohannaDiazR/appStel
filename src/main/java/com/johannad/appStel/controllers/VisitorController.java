package com.johannad.appStel.controllers;

import com.johannad.appStel.business.VisitorBusiness;
import com.johannad.appStel.dtos.VisitorDto;
import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.dtos.WorkerDto;
import com.johannad.appStel.entity.*;
import com.johannad.appStel.service.imp.UserImp;
import com.johannad.appStel.service.imp.VisitorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/visitor", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class VisitorController {

    @Autowired
    private VisitorBusiness visitorBusiness;

    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllVisitor() throws Exception {
        Map<String,Object> res = new HashMap<>();
        List<VisitorDto> listVisitorDto=this.visitorBusiness.findAll();
        res.put("status","success");
        res.put("data",listVisitorDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createVisitor(@RequestBody VisitorDto visitorDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            VisitorDto createdVisitorDto = visitorBusiness.create(visitorDto);
            res.put("status", "success");
            res.put("data", createdVisitorDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateVisitor(@PathVariable int id, @RequestBody VisitorDto updatedVisitorDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            visitorBusiness.update(updatedVisitorDto, id);
            res.put("status", "success");
            res.put("data", updatedVisitorDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
