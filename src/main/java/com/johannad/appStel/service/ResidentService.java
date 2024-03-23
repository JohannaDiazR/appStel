package com.johannad.appStel.service;

import com.johannad.appStel.entity.Resident;

import java.util.List;

public interface ResidentService {
    public List<Resident> findAll() throws Exception;

    public Resident findById(int id);

    public Resident create(Resident resident);

    public void update(Resident resident);

    public void delete(Resident resident);
}
