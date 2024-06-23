package com.johannad.appStel.business;

import com.johannad.appStel.dtos.ParkingDto;
import com.johannad.appStel.entity.Parking;
import com.johannad.appStel.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ParkingBusiness {

    @Autowired
    private ParkingService parkingService;

    public List<ParkingDto> findAll() throws Exception {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDto> parkingDtoList = new ArrayList<>();
        for (Parking parking : parkingList) {
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
        }
        return parkingDtoList;
    }

    public ParkingDto create(ParkingDto parkingDto) throws Exception {
        Parking parking = new Parking();
        parking.setTipoParqueadero(parkingDto.getTipoParqueadero());
        parking.setEstadoParqueadero(parkingDto.getEstadoParqueadero());
        parking.setFecParqueadero(parkingDto.getFecParqueadero());
        parking.setDvteParqueadero(parkingDto.getDvteParqueadero());
        parking.setCupParqueadero(parkingDto.getCupParqueadero());
        parking.setHoraSalida(parkingDto.getHoraSalida());

        // Calcular y asignar el costo del parqueadero
        int costParqueadero = calcularCostoParqueadero(parkingDto.getTipoParqueadero(), parkingDto.getHoraSalida());
        parking.setCostParqueadero(costParqueadero);

        Parking createdParking = parkingService.create(parking);

        parkingDto.setId(createdParking.getId());
        parkingDto.setCostParqueadero(costParqueadero);

        return parkingDto;
    }

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

        // Calcular y asignar el costo del parqueadero
        int costParqueadero = calcularCostoParqueadero(parkingDto.getTipoParqueadero(), parkingDto.getHoraSalida());
        existingParking.setCostParqueadero(costParqueadero);

        parkingService.update(existingParking);
    }

    public void delete(int id) throws Exception {
        Parking existingParking = parkingService.findById(id);
        if (existingParking == null) {
            throw new Exception("Parking not found");
        }

        parkingService.delete(existingParking);
    }

    private int calcularCostoParqueadero(String tipoParqueadero, Date horaSalida) {
        if (tipoParqueadero == null) {
            return 0; // Manejar caso inválido
        }

        // Convertir Date a LocalTime
        LocalTime horaSalidaTime = horaSalida != null ?
                horaSalida.toInstant().atZone(ZoneId.systemDefault()).toLocalTime() :
                null;

        if ("carro-propietario".equalsIgnoreCase(tipoParqueadero)) {
            return 50000; // Costo mensual para carro propietario
        } else if ("moto-propietario".equalsIgnoreCase(tipoParqueadero)) {
            return 36000; // Costo mensual para moto propietario
        } else if ("carro-visitante".equalsIgnoreCase(tipoParqueadero) ||
                "moto-visitante".equalsIgnoreCase(tipoParqueadero)) {
            // Calcular costo según la hora de salida
            if (horaSalidaTime != null && (horaSalidaTime.isAfter(LocalTime.of(18, 0)) || horaSalidaTime.isBefore(LocalTime.of(6, 0)))) {
                return 6000; // Tarifa nocturna
            } else {
                return 4000; // Tarifa diurna
            }
        } else {
            return 0; // Tipo de parqueadero no válido
        }
    }
}
