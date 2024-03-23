package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.Resident;
import com.johannad.appStel.repository.ResidentRepository;
import com.johannad.appStel.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentImp implements ResidentService {
    @Autowired
    private ResidentRepository residentRepository;

    private List<Resident> residentList;

    @Override
    public List<Resident> findAll()throws Exception{
        this.residentList=this.residentRepository.findAll();
        return this.residentList;

    }

    @Override
    public Resident findById(int id){
        Resident resident=this.residentRepository.findById(id);
        return resident;
    }

    @Override
    public Resident create(Resident resident){
        this.residentRepository.save(resident);
        return resident;
    }

    @Override
    public void update(Resident resident){
        this.residentRepository.save(resident);
    }

    @Override
    public void delete(Resident resident){
        this.residentRepository.delete(resident);
    }
}
