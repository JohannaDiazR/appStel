package com.johannad.appStel.business;

import com.johannad.appStel.dtos.RateDto;
import com.johannad.appStel.entity.Rate;
import com.johannad.appStel.entity.Parking;
import com.johannad.appStel.dtos.ParkingDto;
import com.johannad.appStel.service.ParkingService;
import com.johannad.appStel.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RateBusiness {

    @Autowired
    private RateService rateService;
    @Autowired
    private ParkingService parkingService;

    private List<Rate> rateList;

    public List<RateDto> findAll() throws Exception {
        this.rateList = this.rateService.findAll();
        List<RateDto> rateDtoList = new ArrayList<>();
        this.rateList.forEach(rate -> {
            RateDto rateDto = new RateDto();
            rateDto.setId(rate.getId());

            Parking parking = rate.getParking();
            if (parking != null){
                ParkingDto parkingDto = new ParkingDto();
                parkingDto.setId(parking.getId());
                parkingDto.setTipoParqueadero(parking.getTipoParqueadero());
                parkingDto.setEstadoParqueadero(parking.getEstadoParqueadero());
                parkingDto.setFecParqueadero(parking.getFecParqueadero());
                parkingDto.setDvteParqueadero(parking.getDvteParqueadero());
                parkingDto.setCupParqueadero(parking.getCupParqueadero());
                parkingDto.setHoraSalida(parking.getHoraSalida());
                parkingDto.setCostParqueadero(parking.getCostParqueadero());
                rateDto.setParking(parkingDto);

            }
            rateDto.setTipoVehc(rate.getTipoVehc());
            rateDto.setTipoPer(rate.getTipoPer());
            rateDto.setRhoraIni(rate.getRhoraIni());
            rateDto.setRhoraFin(rate.getRhoraFin());
            rateDto.setTarifa(rate.getTarifa());
            rateDtoList.add(rateDto);
        });
        return rateDtoList;
    }

    public RateDto create(RateDto rateDto) throws Exception {
        Rate rate = new Rate();
        rate.setTipoVehc(rateDto.getTipoVehc());
        rate.setTipoPer(rateDto.getTipoPer());
        rate.setRhoraIni(rateDto.getRhoraIni());
        rate.setRhoraFin(rateDto.getRhoraFin());
        rate.setTarifa(rateDto.getTarifa());

        ParkingDto parkingDto = rateDto.getParking();
        if (parkingDto != null){
            Parking parking = parkingService.findById(parkingDto.getId());
            if (parking == null){
                throw new Exception("Parking not found");
            }
            rate.setParking(parking);
        }


        Rate createdRate = rateService.create(rate);

        RateDto createdRateDto = new RateDto();
        createdRateDto.setId(createdRate.getId());
        createdRateDto.setTipoVehc(createdRate.getTipoVehc());
        createdRateDto.setTipoPer(createdRate.getTipoPer());
        createdRateDto.setRhoraIni(createdRate.getRhoraIni());
        createdRateDto.setRhoraFin(createdRate.getRhoraFin());
        createdRateDto.setTarifa(createdRate.getTarifa());
        // Ajusta el mapeo del parking según tu necesidad
        Parking parking = createdRate.getParking();
        if (parking != null) {
            ParkingDto createdParkingDto = new ParkingDto();
            createdParkingDto.setId(parking.getId());
            createdParkingDto.setTipoParqueadero(parking.getTipoParqueadero());
            createdParkingDto.setEstadoParqueadero(parking.getEstadoParqueadero());
            createdParkingDto.setFecParqueadero(parking.getFecParqueadero());
            createdParkingDto.setDvteParqueadero(parking.getDvteParqueadero());
            createdParkingDto.setCupParqueadero(parking.getCupParqueadero());
            createdParkingDto.setHoraSalida(parking.getHoraSalida());
            createdParkingDto.setCostParqueadero(parking.getCostParqueadero());
            createdRateDto.setParking(createdParkingDto);
        }

        return createdRateDto;
    }

    public void update(RateDto rateDto, int id) throws Exception {
        Rate existingRate = rateService.findById(id);
        if (existingRate == null) {
            throw new Exception("Rate not found");
        }

        existingRate.setTipoVehc(rateDto.getTipoVehc());
        existingRate.setTipoPer(rateDto.getTipoPer());
        existingRate.setRhoraIni(rateDto.getRhoraIni());
        existingRate.setRhoraFin(rateDto.getRhoraFin());
        existingRate.setTarifa(rateDto.getTarifa());
        // Ajusta el mapeo del parking según tu necesidad
        ParkingDto parkingDto = rateDto.getParking();
        if (parkingDto != null){
            Parking parking = parkingService.findById(parkingDto.getId());
            if (parking == null){
                throw new Exception("Parking not found");
            }
            existingRate.setParking(parking);
        }

        rateService.update(existingRate);
    }

    public void delete(int id) throws Exception {
        Rate existingRate = rateService.findById(id);
        if (existingRate == null) {
            throw new Exception("Rate not found");
        }

        rateService.delete(existingRate);
    }
}
