package com.johannad.appStel.controllers;

import com.johannad.appStel.business.AdminDocsBusiness;
import com.johannad.appStel.dtos.AdminDocsDto;
import com.johannad.appStel.entity.AdminDocs;
import com.johannad.appStel.service.imp.AdminDocsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping(path = "/api/adminDocs", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")

public class AdminDocsController {

    @Autowired
    private AdminDocsBusiness adminDocsBusiness;
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllAdminDocs() throws Exception {
        Map<String,Object> res = new HashMap<>();
        List<AdminDocsDto> listAdmindocsDto=this.adminDocsBusiness.findAll();
        res.put("status","success");
        res.put("data",listAdmindocsDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createAdminDocs(@RequestBody AdminDocsDto adminDocsDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            AdminDocsDto createdAdminDocsDto = adminDocsBusiness.create(adminDocsDto);
            res.put("status", "success");
            res.put("data", createdAdminDocsDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateAdminDocs(@PathVariable int id, @RequestBody AdminDocsDto updatedAdminDocsDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            adminDocsBusiness.update(updatedAdminDocsDto, id);
            res.put("status", "success");
            res.put("data", updatedAdminDocsDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}








