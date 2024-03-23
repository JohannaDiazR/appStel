package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.Visitor;
import com.johannad.appStel.repository.VisitorRepository;
import com.johannad.appStel.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorImp implements VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    private List<Visitor> visitorList;

    @Override
    public List<Visitor> findAll()throws Exception{
        this.visitorList=this.visitorRepository.findAll();
        return this.visitorList;

    }

    @Override
    public Visitor findById(int id){
        Visitor visitor=this.visitorRepository.findById(id);
        return visitor;
    }

    @Override
    public Visitor create(Visitor visitor){
        this.visitorRepository.save(visitor);
        return visitor;
    }

    @Override
    public void update(Visitor visitor){
        this.visitorRepository.save(visitor);
    }

    @Override
    public void delete(Visitor visitor){
        this.visitorRepository.delete(visitor);
    }
}
