package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.Fine;
import com.johannad.appStel.repository.FineRepository;
import com.johannad.appStel.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FineImp implements FineService {
    @Autowired
    private FineRepository fineRepository;

    private List<Fine> fineList;

    @Override
    public List<Fine> findAll()throws Exception {
        this.fineList=this.fineRepository.findAll();
        return this.fineList;
    }
    @Override
    public Fine findById(int id) {
        Fine fine=this.fineRepository.findById(id);
        return fine;
    }
    @Override
    public Fine create(Fine fine) {
        this.fineRepository.save(fine);
        return fine;
    }
    @Override
    public void update(Fine fine){
        this.fineRepository.save(fine);
    }
    @Override
    public  void delete(Fine fine) {
        this.fineRepository.delete(fine);
    }
}
