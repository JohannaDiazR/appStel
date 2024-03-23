package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.Worker;
import com.johannad.appStel.repository.WorkerRepository;
import com.johannad.appStel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerImp implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    private List<Worker> workerList;

    @Override
    public List<Worker> findAll()throws Exception{
        this.workerList=this.workerRepository.findAll();
        return this.workerList;

    }

    @Override
    public Worker findById(int id){
        Worker worker=this.workerRepository.findById(id);
        return worker;
    }

    @Override
    public Worker create(Worker worker){
        this.workerRepository.save(worker);
        return worker;
    }

    @Override
    public void update(Worker worker){
        this.workerRepository.save(worker);
    }

    @Override
    public void delete(Worker worker){
        this.workerRepository.delete(worker);
    }
}
