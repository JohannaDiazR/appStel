package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.Correspondence;
import com.johannad.appStel.repository.CorrespondenceRepository;
import com.johannad.appStel.service.CorrespondenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrespondenceImp implements CorrespondenceService {

    @Autowired
    private CorrespondenceRepository correspondenceRepository;

    private List<Correspondence> correspondenceList;

    @Override
    public List<Correspondence> findAll(){return this.correspondenceRepository.findAll();}

    @Override
    public Correspondence findById(int id) {
        Correspondence correspondence=this.correspondenceRepository.findById(id);
        return correspondence;
    }
    @Override
    public Correspondence create(Correspondence correspondence) {
        this.correspondenceRepository.save(correspondence);
        return correspondence;
    }
    @Override
    public void update(Correspondence correspondence){
        this.correspondenceRepository.save(correspondence);
    }
    @Override
    public  void delete(Correspondence correspondence) {
        this.correspondenceRepository.delete(correspondence);
    }
}