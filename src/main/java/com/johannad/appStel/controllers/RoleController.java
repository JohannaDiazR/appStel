package com.johannad.appStel.controllers;


import com.johannad.appStel.business.RoleBusiness;
import com.johannad.appStel.dtos.RoleDto;
import com.johannad.appStel.dtos.UserDto;
import com.johannad.appStel.dtos.WorkerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/role", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class RoleController {
    @Autowired
    private RoleBusiness roleBusiness;
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllRole() throws Exception {
        Map<String,Object> res = new HashMap<>();
        List<RoleDto> listRoleDto=this.roleBusiness.findAll();
        res.put("status","success");
        res.put("data",listRoleDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createRole(@RequestBody RoleDto roleDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            RoleDto createdRoleDto = roleBusiness.create(roleDto);
            res.put("status", "success");
            res.put("data", createdRoleDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateRole(@PathVariable int id, @RequestBody RoleDto updatedRoleDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            roleBusiness.update(updatedRoleDto, id);
            res.put("status", "success");
            res.put("data", updatedRoleDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteRole(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            roleBusiness.delete(id);
            res.put("status", "success");
            res.put("message", "Role deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
