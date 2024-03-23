package com.johannad.appStel.service;

import com.johannad.appStel.entity.Correspondence;

import java.util.List;

public interface CorrespondenceService {

    public List<Correspondence> findAll() throws Exception;
    public Correspondence findById(int id);
    public Correspondence create(Correspondence correspondence);
    public void update(Correspondence correspondence);
    public void delete(Correspondence correspondence);
}
