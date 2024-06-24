package com.johannad.appStel.controllers;

import com.johannad.appStel.business.UserBusiness;
import com.johannad.appStel.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/user", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
//@CrossOrigin(origins = {"http://localhost:3000", "https://f965-2800-e6-1010-8eb4-2915-39ac-f6f7-beff.ngrok-free.app"})
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserBusiness userBusiness;


    @GetMapping("/all")
    public String redirectToLoginPage() {
        // Redirigir a la página de login de React
        return "redirect:http://localhost:3000/ingresar";
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            UserDto createdUserDto = userBusiness.create(userDto);
            res.put("status", "success");
            res.put("data", createdUserDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable int id, @RequestBody UserDto updatedUserDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            userBusiness.update(updatedUserDto, id);
            res.put("status", "success");
            res.put("data", updatedUserDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            userBusiness.delete(id);
            res.put("status", "success");
            res.put("message", "User deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
