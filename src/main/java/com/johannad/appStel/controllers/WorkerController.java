package com.johannad.appStel.controllers;


import com.johannad.appStel.business.WorkerBusiness;
import com.johannad.appStel.dtos.WorkerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(path = "/api/worker", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class WorkerController {
    @Autowired
    private WorkerBusiness workerBusiness;


    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllWorker() throws Exception {

        Map<String,Object> res = new HashMap<>();
        List<WorkerDto> listWorkerDto=this.workerBusiness.findAll();
        res.put("status","success");
        res.put("data",listWorkerDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createWorker(@RequestBody WorkerDto workerDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            WorkerDto createdWorkerDto = workerBusiness.create(workerDto);
            res.put("status", "success");
            res.put("data", createdWorkerDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateWorker(@PathVariable int id, @RequestBody WorkerDto updatedWorkerDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            workerBusiness.update(updatedWorkerDto, id);
            res.put("status", "success");
            res.put("data", updatedWorkerDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
