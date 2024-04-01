package com.johannad.appStel.controllers;


import com.johannad.appStel.business.WalletStatusBusiness;
import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.entity.WalletStatus;
import com.johannad.appStel.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/walletStatus", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")
public class WalletStatusController {
    @Autowired
    private WalletStatusBusiness walletStatusBusiness;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> findAllWalletStatus() throws Exception {
        Map<String, Object> res = new HashMap<>();
        List<WalletStatusDto> listWalletStatusDto = this.walletStatusBusiness.findAll();
        res.put("status", "success");
        res.put("data", listWalletStatusDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createWalletStatus(@RequestBody WalletStatusDto walletStatusDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            WalletStatusDto createdWalletStatusDto = walletStatusBusiness.create(walletStatusDto);
            res.put("status", "success");
            res.put("data", createdWalletStatusDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateWalletStatus(@PathVariable int id, @RequestBody WalletStatusDto updatedWalletStatusDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            walletStatusBusiness.update(updatedWalletStatusDto, id);
            res.put("status", "success");
            res.put("data", updatedWalletStatusDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteWalletStatus(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            walletStatusBusiness.delete(id);
            res.put("status", "success");
            res.put("message", "WalletStatus deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

