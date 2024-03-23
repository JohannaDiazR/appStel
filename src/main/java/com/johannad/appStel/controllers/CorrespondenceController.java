package com.johannad.appStel.controllers;

import com.johannad.appStel.business.CorrespondenceBusiness;
import com.johannad.appStel.dtos.CorrespondenceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/correspondence", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")

public class CorrespondenceController {

    @Autowired
    private CorrespondenceBusiness correspondenceBusiness;
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllCorrespondence() throws Exception {
        Map<String,Object> res = new HashMap<>();
        List<CorrespondenceDto> listCorrespondenceDto=this.correspondenceBusiness.findAll();
        res.put("status","success");
        res.put("data",listCorrespondenceDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createCorrespondence(@RequestBody CorrespondenceDto correspondenceDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            CorrespondenceDto createdCorrespondenceDto = correspondenceBusiness.create(correspondenceDto);
            res.put("status", "success");
            res.put("data", createdCorrespondenceDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateCorrespondence(@PathVariable int id, @RequestBody CorrespondenceDto updatedCorrespondenceDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            correspondenceBusiness.update(updatedCorrespondenceDto, id);
            res.put("status", "success");
            res.put("data", updatedCorrespondenceDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
