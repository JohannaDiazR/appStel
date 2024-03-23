package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.Parking;
import com.johannad.appStel.repository.ParkingRepository;
import com.johannad.appStel.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingImp implements ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    private List<Parking> parkingList;

    @Override
    public List<Parking> findAll()throws Exception{
        this.parkingList=this.parkingRepository.findAll();
        return this.parkingList;

    }

    @Override
    public Parking findById(int id){
        Parking parking=this.parkingRepository.findById(id);
        return parking;
    }

    @Override
    public Parking create(Parking parking){
        this.parkingRepository.save(parking);
        return parking;
    }

    @Override
    public void update(Parking parking){
        this.parkingRepository.save(parking);
    }

    @Override
    public void delete(Parking parking){
        this.parkingRepository.delete(parking);
    }
}
