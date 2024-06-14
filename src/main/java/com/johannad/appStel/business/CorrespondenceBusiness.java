package com.johannad.appStel.business;

import com.johannad.appStel.dtos.CorrespondenceDto;
import com.johannad.appStel.dtos.PropertyDto;
import com.johannad.appStel.dtos.WorkerDto;
import com.johannad.appStel.entity.Correspondence;
import com.johannad.appStel.entity.Property;
import com.johannad.appStel.entity.User;
import com.johannad.appStel.entity.Worker;
import com.johannad.appStel.service.CorrespondenceService;
import com.johannad.appStel.service.PropertyService;
import com.johannad.appStel.service.UserService;
import com.johannad.appStel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CorrespondenceBusiness {

    @Autowired
    private CorrespondenceService correspondenceService;

    @Autowired
    private WorkerService workerService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;

    //private List<Correspondence> correspondenceList;

    public List<CorrespondenceDto> findAll() throws Exception {
        List<Correspondence> correspondenceList = correspondenceService.findAll();
        //this.correspondenceList = this.correspondenceService.findAll();
        List<CorrespondenceDto> correspondenceDtoList = new ArrayList<>();
        for (Correspondence correspondence : correspondenceList) {
            CorrespondenceDto correspondenceDto = new CorrespondenceDto();
            correspondenceDto.setId(correspondence.getId());
            correspondenceDto.setTipoCorrespondencia(correspondence.getTipoCorrespondencia());
            correspondenceDto.setFrecCorrespondencia(correspondence.getFrecCorrespondencia());
            correspondenceDto.setEstCorrespondencia(correspondence.getEstCorrespondencia());
            correspondenceDto.setFentrCorrespondencia(correspondence.getFentrCorrespondencia());


            Worker worker = correspondence.getWorker();
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

                correspondenceDto.setWorker(workerDto);
            }
            Property property = correspondence.getProperty();
            if (property != null) {
                PropertyDto propertyDto = new PropertyDto();
                propertyDto.setId(property.getId());
                propertyDto.setAndInmueble(property.getAndInmueble());
                propertyDto.setNumInmueble(property.getNumInmueble());
                correspondenceDto.setProperty(propertyDto);
            }
            correspondenceDtoList.add(correspondenceDto);
        }
        return correspondenceDtoList;
    }

    // POST
    public CorrespondenceDto create(CorrespondenceDto correspondenceDto) throws Exception {
        Correspondence correspondence = new Correspondence();
        correspondence.setTipoCorrespondencia(correspondenceDto.getTipoCorrespondencia());
        correspondence.setFrecCorrespondencia(correspondenceDto.getFrecCorrespondencia());
        correspondence.setEstCorrespondencia(correspondenceDto.getEstCorrespondencia());
        correspondence.setFentrCorrespondencia(correspondenceDto.getFentrCorrespondencia());

        WorkerDto workerDto = correspondenceDto.getWorker();
        if (workerDto != null) {
            Worker worker = workerService.findById(workerDto.getId());
            if (worker != null) {
                correspondence.setWorker(worker);
            }
        }
        PropertyDto propertyDto = correspondenceDto.getProperty();
        if (propertyDto != null) {
            Property property = propertyService.findById(propertyDto.getId());
            correspondence.setProperty(property);
        }

        Correspondence createdCorrespondence = correspondenceService.create(correspondence);
        CorrespondenceDto createdCorrespondenceDto = new CorrespondenceDto();
        createdCorrespondenceDto.setId(createdCorrespondence.getId());
        createdCorrespondenceDto.setTipoCorrespondencia(createdCorrespondence.getTipoCorrespondencia());
        createdCorrespondenceDto.setFrecCorrespondencia(createdCorrespondence.getFrecCorrespondencia());
        createdCorrespondenceDto.setEstCorrespondencia(createdCorrespondence.getEstCorrespondencia());
        createdCorrespondenceDto.setFentrCorrespondencia(createdCorrespondence.getFentrCorrespondencia());

        Worker worker = createdCorrespondence.getWorker();
        if (worker != null) {
            WorkerDto createdWorkerDto = new WorkerDto();
            createdWorkerDto.setId(worker.getId());
            createdWorkerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
            createdWorkerDto.setCargTrabajador(worker.getCargTrabajador());
            createdWorkerDto.setEmpTrabajador(worker.getEmpTrabajador());
            createdCorrespondenceDto.setWorker(createdWorkerDto);
        }
        Property property = createdCorrespondence.getProperty();
        if (property != null) {
            PropertyDto createdPropertyDto = new PropertyDto();
            createdPropertyDto.setId(property.getId());
            createdPropertyDto.setAndInmueble(property.getAndInmueble());
            createdPropertyDto.setNumInmueble(property.getNumInmueble());
            createdCorrespondenceDto.setProperty(createdPropertyDto);
        }

        return createdCorrespondenceDto;
    }

    // PUT
    public void update(CorrespondenceDto correspondenceDto, int id) throws Exception {
        Correspondence existingCorrespondence = correspondenceService.findById(id);
        if (existingCorrespondence == null) {
            throw new Exception("Correspondence not found");
        }

        existingCorrespondence.setTipoCorrespondencia(correspondenceDto.getTipoCorrespondencia());
        existingCorrespondence.setFrecCorrespondencia(correspondenceDto.getFrecCorrespondencia());
        existingCorrespondence.setEstCorrespondencia(correspondenceDto.getEstCorrespondencia());
        existingCorrespondence.setFentrCorrespondencia(correspondenceDto.getFentrCorrespondencia());

        // Manejo de Trabajador
        WorkerDto workerDto = correspondenceDto.getWorker();
        if (workerDto != null) {
            Worker worker = workerService.findById(workerDto.getId());
            if (worker != null) {
                existingCorrespondence.setWorker(worker);
            } else {
                // Si el trabajador no existe, podrías lanzar una excepción o manejarlo de otra manera
                throw new Exception("Worker not found");
            }
        } else {
            // Si el campo de trabajador está vacío, podrías manejarlo de alguna manera
            existingCorrespondence.setWorker(null); // O dejar el trabajador como null dependiendo de tus requerimientos
        }

        // Manejo de Propiedad
        PropertyDto propertyDto = correspondenceDto.getProperty();
        if (propertyDto != null) {
            Property property = propertyService.findById(propertyDto.getId());
            if (property != null) {
                existingCorrespondence.setProperty(property);
            } else {
                // Si la propiedad no existe, podrías lanzar una excepción o manejarlo de otra manera
                throw new Exception("Property not found");
            }
        } else {
            // Si el campo de propiedad está vacío, podrías manejarlo de alguna manera
            existingCorrespondence.setProperty(null); // O dejar la propiedad como null dependiendo de tus requerimientos
        }

        correspondenceService.update(existingCorrespondence);
    }

    public void delete(int id) throws Exception {
        Correspondence existingCorrespondence = correspondenceService.findById(id);
        if (existingCorrespondence == null) {
            throw new Exception("Correspondence not found");
        }

        correspondenceService.delete(existingCorrespondence);
    }


}