package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.Rate;
import com.johannad.appStel.repository.RateRepository;
import com.johannad.appStel.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateImp implements RateService {
    @Autowired
    private RateRepository rateRepository;
    private List<Rate> rateList;
    @Override
    public List<Rate> findAll()throws Exception{
        this.rateList=this.rateRepository.findAll();
        return this.rateList;
    }
    @Override
    public Rate findById(int id){
        Rate rate=this.rateRepository.findById(id);
        return rate;
    }

    @Override
    public Rate create(Rate rate){
        this.rateRepository.save(rate);
        return rate;
    }

    @Override
    public void update(Rate rate){
        this.rateRepository.save(rate);
    }

    @Override
    public void delete(Rate rate){
        this.rateRepository.delete(rate);
    }
}


