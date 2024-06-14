package com.johannad.appStel.service;

import com.johannad.appStel.entity.Rate;

import java.util.List;

public interface RateService {
    public List<Rate> findAll() throws Exception;
    public Rate findById(int id);
    public Rate create(Rate rate);
    public void update(Rate rate);
    public void delete(Rate rate);
}
