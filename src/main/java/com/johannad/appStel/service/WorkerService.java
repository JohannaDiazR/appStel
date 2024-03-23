package com.johannad.appStel.service;

import com.johannad.appStel.entity.Worker;

import java.util.List;

public interface WorkerService {
    public List<Worker> findAll() throws Exception;

    public Worker findById(int id);

    public Worker create(Worker worker);

    public void update(Worker worker);

    public void delete(Worker worker);

}
