package com.johannad.appStel.service;

import com.johannad.appStel.entity.Parking;

import java.util.List;

public interface ParkingService {
    public List<Parking> findAll() throws Exception;

    public Parking findById(int id);

    public Parking create(Parking parking);

    public void update(Parking parking);

    public void delete(Parking parking);
}
