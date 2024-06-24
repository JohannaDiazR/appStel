package com.johannad.appStel.business;

import com.johannad.appStel.dtos.ParkingDto;

import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.entity.Parking;

import com.johannad.appStel.entity.WalletStatus;
import com.johannad.appStel.service.ParkingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParkingBusiness {
    @Autowired
    private ParkingService parkingService;

    private List<Parking> parkingList;

    public List<ParkingDto> findAll() throws Exception {
        this.parkingList = this.parkingService.findAll();
        List<ParkingDto> parkingDtoList = new ArrayList<>();
        this.parkingList.forEach(parking -> {
            ParkingDto parkingDto = new ParkingDto();
            parkingDto.setId(parking.getId());
            parkingDto.setTipoParqueadero(parking.getTipoParqueadero());
            parkingDto.setEstadoParqueadero(parking.getEstadoParqueadero());
            parkingDto.setFecParqueadero(parking.getFecParqueadero());
            parkingDto.setDvteParqueadero(parking.getDvteParqueadero());
            parkingDto.setCupParqueadero(parking.getCupParqueadero());
            parkingDto.setHoraSalida(parking.getHoraSalida());
            parkingDto.setCostParqueadero(parking.getCostParqueadero());


            parkingDtoList.add(parkingDto);
        });
        return parkingDtoList;
    }
    //POST
    public ParkingDto create(ParkingDto parkingDto) throws Exception {
        Parking parking = new Parking();
        parking.setTipoParqueadero(parkingDto.getTipoParqueadero());
        parking.setEstadoParqueadero(parkingDto.getEstadoParqueadero());
        parking.setFecParqueadero(parkingDto.getFecParqueadero());
        parking.setDvteParqueadero(parkingDto.getDvteParqueadero());
        parking.setCupParqueadero(parkingDto.getCupParqueadero());
        parking.setHoraSalida(parkingDto.getHoraSalida());
        parking.setCostParqueadero(parkingDto.getCostParqueadero());




        Parking createdParking = parkingService.create(parking);

        ParkingDto createdParkingDto = new ParkingDto();
        createdParkingDto.setId(createdParking.getId());
        createdParkingDto.setTipoParqueadero(createdParking.getTipoParqueadero());
        createdParkingDto.setEstadoParqueadero(createdParking.getEstadoParqueadero());
        createdParkingDto.setFecParqueadero(createdParking.getFecParqueadero());
        createdParkingDto.setDvteParqueadero(createdParking.getDvteParqueadero());
        createdParkingDto.setCupParqueadero(createdParking.getCupParqueadero());
        createdParkingDto.setHoraSalida(createdParking.getHoraSalida());
        createdParkingDto.setCostParqueadero(createdParking.getCostParqueadero());


        return createdParkingDto;
    }
    //PUT
    public void update(ParkingDto parkingDto, int id) throws Exception {
        Parking existingParking = parkingService.findById(id);
        if (existingParking == null) {
            throw new Exception("Parking not found");
        }

        existingParking.setTipoParqueadero(parkingDto.getTipoParqueadero());
        existingParking.setEstadoParqueadero(parkingDto.getEstadoParqueadero());
        existingParking.setFecParqueadero(parkingDto.getFecParqueadero());
        existingParking.setDvteParqueadero(parkingDto.getDvteParqueadero());
        existingParking.setCupParqueadero(parkingDto.getCupParqueadero());
        existingParking.setHoraSalida(parkingDto.getHoraSalida());
        existingParking.setCostParqueadero(parkingDto.getCostParqueadero());


        parkingService.update(existingParking);
    }

    public void delete(int id) throws Exception {
        Parking existingParking = parkingService.findById(id);
        if (existingParking == null) {
            throw new Exception("Worker not found");
        }

        parkingService.delete(existingParking);
    }
}