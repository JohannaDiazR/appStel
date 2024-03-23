package com.johannad.appStel.business;

import com.johannad.appStel.dtos.*;
import com.johannad.appStel.entity.Parking;
import com.johannad.appStel.entity.Property;
import com.johannad.appStel.entity.Visitor;
import com.johannad.appStel.entity.Worker;
import com.johannad.appStel.service.ParkingService;
import com.johannad.appStel.service.PropertyService;
import com.johannad.appStel.service.VisitorService;
import com.johannad.appStel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VisitorBusiness {
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private ParkingService parkingService;

    private List<Visitor> visitorList;


    public List<VisitorDto> findAll() throws Exception {
        this.visitorList =this.visitorService.findAll();
        List<VisitorDto> visitorDtoList = new ArrayList<>();
        this.visitorList.forEach(visitor -> {
            VisitorDto visitorDto=new VisitorDto();
            visitorDto.setId(visitor.getId());

            Worker worker = visitor.getWorker();
            if (worker != null){
                WorkerDto workerDto = new WorkerDto();
                workerDto.setId(worker.getId());
                workerDto.setNomTrabajador(worker.getNomTrabajador());
                workerDto.setCcTrabajador(worker.getCcTrabajador());
                workerDto.setCelTrabajador(worker.getCelTrabajador());
                workerDto.setEmaTrabajador(worker.getEmaTrabajador());
                workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
                workerDto.setConTrabajador(worker.getConTrabajador());
                workerDto.setCargTrabajador(worker.getCargTrabajador());
                workerDto.setEmpTrabajador(worker.getEmpTrabajador());
                visitorDto.setWorker(workerDto);
            }
            Parking parking = visitor.getParking();
            if (parking != null){
                ParkingDto parkingDto = new ParkingDto();
                parkingDto.setId(parking.getId());
                parkingDto.setTipoParqueadero(parking.getTipoParqueadero());
                parkingDto.setEstadoParqueadero(parking.getEstadoParqueadero());
                parkingDto.setFecParqueadero(parking.getFecParqueadero());
                parkingDto.setDvteParqueadero(parking.getDvteParqueadero());
                parkingDto.setCupParqueadero(parking.getCupParqueadero());
                parkingDto.setHoraSalida(parking.getHoraSalida());
                parkingDto.setTarParqueadero(parking.getTarParqueadero());
                visitorDto.setParking(parkingDto);
            }

            Property property = visitor.getProperty();
            if (property != null){
                PropertyDto propertyDto = new PropertyDto();
                propertyDto.setId(property.getId());
                propertyDto.setAndInmueble(property.getAndInmueble());
                propertyDto.setNumInmueble(property.getNumInmueble());
                visitorDto.setProperty(propertyDto);
            }

            visitorDto.setNomVisitante(visitor.getNomVisitante());
            visitorDto.setCedVisitante(visitor.getCedVisitante());
            visitorDto.setNomResidente(visitor.getNomResidente());
            visitorDto.setCarVisitante(visitor.isCarVisitante());
            visitorDto.setIngrVisitante(visitor.isIngrVisitante());
            visitorDto.setFecVisitante(visitor.getFecVisitante());
            visitorDtoList.add(visitorDto);
        });
        return visitorDtoList;
    }
    //POST
    public VisitorDto create(VisitorDto visitorDto) throws Exception {
        Visitor visitor = new Visitor();
        visitor.setNomVisitante(visitorDto.getNomVisitante());
        visitor.setCedVisitante(visitorDto.getCedVisitante());
        visitor.setNomResidente(visitorDto.getNomResidente());
        visitor.setCarVisitante(visitorDto.isCarVisitante());
        visitor.setIngrVisitante(visitorDto.isIngrVisitante());
        visitor.setFecVisitante(visitorDto.getFecVisitante());

        WorkerDto workerDto = visitorDto.getWorker();
        if (workerDto != null) {
            Worker worker = new Worker();
            worker.setId(workerDto.getId());
            worker.setNomTrabajador(workerDto.getNomTrabajador());
            worker.setCcTrabajador(workerDto.getCcTrabajador());
            worker.setCelTrabajador(workerDto.getCelTrabajador());
            worker.setEmaTrabajador(workerDto.getEmaTrabajador());
            worker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
            worker.setConTrabajador(workerDto.getConTrabajador());
            worker.setCargTrabajador(workerDto.getCargTrabajador());
            worker.setEmpTrabajador(workerDto.getEmpTrabajador());
            visitor.setWorker(worker);
        }
        ParkingDto parkingDto = visitorDto.getParking();
        if (parkingDto != null) {
            Parking parking = new Parking();
            parking.setId(parkingDto.getId());
            parking.setTipoParqueadero(parkingDto.getTipoParqueadero());
            parking.setEstadoParqueadero(parkingDto.getEstadoParqueadero());
            parking.setFecParqueadero(parkingDto.getFecParqueadero());
            parking.setDvteParqueadero(parkingDto.getDvteParqueadero());
            parking.setCupParqueadero(parkingDto.getCupParqueadero());
            parking.setHoraSalida(parkingDto.getHoraSalida());
            parking.setTarParqueadero(parkingDto.getTarParqueadero());
        }

        PropertyDto propertyDto = visitorDto.getProperty();
        if (propertyDto != null) {
            Property property = new Property();
            property.setId(propertyDto.getId());
            property.setAndInmueble(propertyDto.getAndInmueble());
            property.setNumInmueble(propertyDto.getNumInmueble());
        }

        Visitor createdVisitor = visitorService.create(visitor);
        VisitorDto createdVisitorDto = new VisitorDto();
        createdVisitorDto.setId(createdVisitor.getId());
        createdVisitorDto.setNomVisitante(createdVisitor.getNomVisitante());
        createdVisitorDto.setCedVisitante(createdVisitor.getCedVisitante());
        createdVisitorDto.setNomResidente(createdVisitor.getNomResidente());
        createdVisitorDto.setCarVisitante(createdVisitor.isCarVisitante());
        createdVisitorDto.setIngrVisitante(createdVisitor.isIngrVisitante());
        createdVisitorDto.setFecVisitante(createdVisitor.getFecVisitante());

        Worker worker = createdVisitor.getWorker();
        if (worker != null) {
            workerDto = new WorkerDto();
            workerDto.setId(worker.getId());
            workerDto.setNomTrabajador(worker.getNomTrabajador());
            workerDto.setCcTrabajador(worker.getCcTrabajador());
            workerDto.setCelTrabajador(worker.getCelTrabajador());
            workerDto.setEmaTrabajador(worker.getEmaTrabajador());
            workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
            workerDto.setConTrabajador(worker.getConTrabajador());
            workerDto.setCargTrabajador(worker.getCargTrabajador());
            workerDto.setEmpTrabajador(worker.getEmpTrabajador());
            createdVisitorDto.setWorker(workerDto);
        }
        Parking parking = createdVisitor.getParking();
        if (parking != null) {
            parkingDto = new ParkingDto();
            parkingDto.setId(parking.getId());
            parkingDto.setTipoParqueadero(parking.getTipoParqueadero());
            parkingDto.setEstadoParqueadero(parking.getEstadoParqueadero());
            parkingDto.setFecParqueadero(parking.getFecParqueadero());
            parkingDto.setDvteParqueadero(parking.getDvteParqueadero());
            parkingDto.setCupParqueadero(parking.getCupParqueadero());
            parkingDto.setHoraSalida(parking.getHoraSalida());
            parkingDto.setTarParqueadero(parking.getTarParqueadero());
        }
        Property property = createdVisitor.getProperty();
        if (property != null) {
            propertyDto = new PropertyDto();
            propertyDto.setId(property.getId());
            propertyDto.setAndInmueble(property.getAndInmueble());
            propertyDto.setNumInmueble(property.getNumInmueble());
        }
        return  createdVisitorDto;
    }

    //PUT
    public  void update(VisitorDto visitorDto, int id) throws Exception {
        Visitor existingVisitor = visitorService.findById(id);
        if (existingVisitor == null) {
            throw new Exception("Visitor not found");
        }

        existingVisitor.setNomVisitante(visitorDto.getNomVisitante());
        existingVisitor.setCedVisitante(visitorDto.getCedVisitante());
        existingVisitor.setNomResidente(visitorDto.getNomResidente());
        existingVisitor.setCarVisitante(visitorDto.isCarVisitante());
        existingVisitor.setIngrVisitante(visitorDto.isIngrVisitante());
        existingVisitor.setFecVisitante(visitorDto.getFecVisitante());

        WorkerDto workerDto = visitorDto.getWorker();
        if (workerDto != null) {
            Worker existingWorker = existingVisitor.getWorker();
            if (existingWorker == null) {
                existingWorker = new Worker();
            }
            existingWorker.setId(workerDto.getId());
            existingWorker.setNomTrabajador(workerDto.getNomTrabajador());
            existingWorker.setCcTrabajador(workerDto.getCcTrabajador());
            existingWorker.setCelTrabajador(workerDto.getCelTrabajador());
            existingWorker.setEmaTrabajador(workerDto.getEmaTrabajador());
            existingWorker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
            existingWorker.setConTrabajador(workerDto.getConTrabajador());
            existingWorker.setCargTrabajador(workerDto.getCargTrabajador());
            existingWorker.setEmpTrabajador(workerDto.getEmpTrabajador());

            existingVisitor.setWorker(existingWorker);
        }
        ParkingDto parkingDto = visitorDto.getParking();
        if (parkingDto != null) {
            Parking existingParking = existingVisitor.getParking();
            if (existingParking == null) {
                existingParking = new Parking();
            }
            existingParking.setId(parkingDto.getId());
            existingParking.setTipoParqueadero(parkingDto.getTipoParqueadero());
            existingParking.setEstadoParqueadero(parkingDto.getEstadoParqueadero());
            existingParking.setFecParqueadero(parkingDto.getFecParqueadero());
            existingParking.setDvteParqueadero(parkingDto.getDvteParqueadero());
            existingParking.setCupParqueadero(parkingDto.getCupParqueadero());
            existingParking.setHoraSalida(parkingDto.getHoraSalida());
            existingParking.setTarParqueadero(parkingDto.getTarParqueadero());
            existingVisitor.setParking(existingParking);
        }

        PropertyDto propertyDto = visitorDto.getProperty();
        if (propertyDto != null) {
            Property existingProperty = existingVisitor.getProperty();
            if (existingProperty == null) {
                existingProperty = new Property();
            }
            existingProperty.setId(propertyDto.getId());
            existingProperty.setAndInmueble(propertyDto.getAndInmueble());
            existingProperty.setNumInmueble(propertyDto.getNumInmueble());
            existingVisitor.setProperty(existingProperty);
        }
        visitorService.update(existingVisitor);
    }

}