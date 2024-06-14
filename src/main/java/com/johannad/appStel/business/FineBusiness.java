package com.johannad.appStel.business;

import com.johannad.appStel.dtos.FineDto;
import com.johannad.appStel.dtos.PropertyDto;
import com.johannad.appStel.dtos.WorkerDto;
import com.johannad.appStel.entity.Fine;
import com.johannad.appStel.entity.Property;
import com.johannad.appStel.entity.User;
import com.johannad.appStel.entity.Worker;
import com.johannad.appStel.service.FineService;
import com.johannad.appStel.service.PropertyService;
import com.johannad.appStel.service.UserService;
import com.johannad.appStel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FineBusiness {

    @Autowired
    private FineService fineService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private UserService userService;

    /**
     * Método para obtener todas las multas.
     */
    public List<FineDto> findAll() throws Exception {
        List<Fine> fineList = fineService.findAll();
        List<FineDto> fineDtoList = new ArrayList<>();

        for (Fine fine : fineList) {
            FineDto fineDto = new FineDto();
            fineDto.setId(fine.getId());
            fineDto.setTipoMulta(fine.getTipoMulta());
            fineDto.setFecMulta(fine.getFecMulta());
            fineDto.setValMulta(fine.getValMulta());
            fineDto.setFpagMulta(fine.getFpagMulta());

            // Mapeo de la propiedad
            Property property = fine.getProperty();
            if (property != null) {
                PropertyDto propertyDto = new PropertyDto();
                propertyDto.setId(property.getId());
                propertyDto.setAndInmueble(property.getAndInmueble());
                propertyDto.setNumInmueble(property.getNumInmueble());
                fineDto.setProperty(propertyDto);
            }

            // Mapeo del trabajador y el usuario asociado
            Worker worker = fine.getWorker();
            if (worker != null) {
                WorkerDto workerDto = new WorkerDto();
                workerDto.setId(worker.getId());
                workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
                workerDto.setCargTrabajador(worker.getCargTrabajador());
                workerDto.setEmpTrabajador(worker.getEmpTrabajador());

                User user = worker.getUser();
                if (user != null) {
                    workerDto.setUserName(user.getNombre());
                    workerDto.setUserCedula(user.getCedula());
                }

                fineDto.setWorker(workerDto);
            }

            fineDtoList.add(fineDto);
        }
        return fineDtoList;
    }

    /**
     * Método para crear una nueva multa.
     */
    public FineDto create(FineDto fineDto) throws Exception {
        Fine fine = new Fine();
        fine.setTipoMulta(fineDto.getTipoMulta());
        fine.setFecMulta(fineDto.getFecMulta());
        fine.setValMulta(fineDto.getValMulta());
        fine.setFpagMulta(fineDto.getFpagMulta());

        // Asignar la propiedad si está presente en el DTO
        PropertyDto propertyDto = fineDto.getProperty();
        if (propertyDto != null) {
            Property property = propertyService.findById(propertyDto.getId());
            fine.setProperty(property);
        }

        // Asignar el trabajador si está presente en el DTO
        WorkerDto workerDto = fineDto.getWorker();
        if (workerDto != null) {
            Worker worker = workerService.findById(workerDto.getId());
            if (worker != null) {
                fine.setWorker(worker);
            }
        }

        // Guardar la multa creada
        Fine createdFine = fineService.create(fine);

        // Convertir la multa creada a FineDto para la respuesta
        FineDto createdFineDto = new FineDto();
        createdFineDto.setId(createdFine.getId());
        createdFineDto.setTipoMulta(createdFine.getTipoMulta());
        createdFineDto.setFecMulta(createdFine.getFecMulta());
        createdFineDto.setValMulta(createdFine.getValMulta());
        createdFineDto.setFpagMulta(createdFine.getFpagMulta());

        // Asignar la propiedad al DTO si está presente en la multa creada
        Property property = createdFine.getProperty();
        if (property != null) {
            PropertyDto propertyDtoResp = new PropertyDto();
            propertyDtoResp.setId(property.getId());
            propertyDtoResp.setAndInmueble(property.getAndInmueble());
            propertyDtoResp.setNumInmueble(property.getNumInmueble());
            createdFineDto.setProperty(propertyDtoResp);
        }

        // Asignar el trabajador al DTO si está presente en la multa creada
        Worker worker = createdFine.getWorker();
        if (worker != null) {
            WorkerDto workerDtoResp = new WorkerDto();
            workerDtoResp.setId(worker.getId());
            workerDtoResp.setTpcoTrabajador(worker.getTpcoTrabajador());
            workerDtoResp.setCargTrabajador(worker.getCargTrabajador());
            workerDtoResp.setEmpTrabajador(worker.getEmpTrabajador());

            User user = worker.getUser();
            if (user != null) {
                workerDtoResp.setUserName(user.getNombre());
                workerDtoResp.setUserCedula(user.getCedula());
            }

            createdFineDto.setWorker(workerDtoResp);
        }

        return createdFineDto;
    }

    /**
     * Método para actualizar una multa existente.
     */
    public void update(FineDto fineDto, int id) throws Exception {
        Fine existingFine = fineService.findById(id);
        if (existingFine == null) {
            throw new Exception("Fine not found");
        }

        existingFine.setTipoMulta(fineDto.getTipoMulta());
        existingFine.setFecMulta(fineDto.getFecMulta());
        existingFine.setValMulta(fineDto.getValMulta());
        existingFine.setFpagMulta(fineDto.getFpagMulta());

        PropertyDto propertyDto = fineDto.getProperty();
        if (propertyDto != null) {
            Property property = propertyService.findById(propertyDto.getId());
            if (property != null) {
                existingFine.setProperty(property);
            }
        }

        WorkerDto workerDto = fineDto.getWorker();
        if (workerDto != null) {
            Worker worker = workerService.findById(workerDto.getId());
            if (worker != null) {
                existingFine.setWorker(worker);
            }
        }

        fineService.update(existingFine);
    }

    /**
     * Método para eliminar una multa.
     */
    public void delete(int id) throws Exception {
        Fine existingFine = fineService.findById(id);
        if (existingFine == null) {
            throw new Exception("Fine not found");
        }

        fineService.delete(existingFine);
    }
}
