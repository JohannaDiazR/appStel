package com.johannad.appStel.controllers;

import com.johannad.appStel.business.NewsBusiness;
import com.johannad.appStel.dtos.NewsDto;
import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.entity.Fine;
import com.johannad.appStel.entity.News;
import com.johannad.appStel.service.imp.NewsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/news", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin("*")

public class NewsController {
    @Autowired
    private NewsBusiness newsBusiness;
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAllNews() throws Exception {
       Map<String,Object> res = new HashMap<>();
        List<NewsDto> listNewsDto = this.newsBusiness.findAll();
        res.put("status","success");
        res.put("data",listNewsDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createNews(@RequestBody NewsDto newsDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            NewsDto createdNewsDto = newsBusiness.create(newsDto);
            res.put("status", "success");
            res.put("data", createdNewsDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateNews(@PathVariable int id, @RequestBody NewsDto updatedNewsDto) {
        Map<String, Object> res = new HashMap<>();
        try {
            newsBusiness.update(updatedNewsDto, id);
            res.put("status", "success");
            res.put("data", updatedNewsDto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteNews(@PathVariable int id) {
        Map<String, Object> res = new HashMap<>();
        try {
            newsBusiness.delete(id);
            res.put("status", "success");
            res.put("message", "News deleted successfully");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.put("status", "error");
            res.put("message", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
