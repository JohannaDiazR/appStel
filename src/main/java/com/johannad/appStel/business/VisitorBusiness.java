package com.johannad.appStel.business;

import com.johannad.appStel.dtos.*;
import com.johannad.appStel.entity.*;
import com.johannad.appStel.service.*;
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
    private ParkingService parkingService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;

    private List<Visitor> visitorList;

    public List<VisitorDto> findAll() throws Exception {
        this.visitorList = this.visitorService.findAll();
        List<VisitorDto> visitorDtoList = new ArrayList<>();
        this.visitorList.forEach(visitor -> {
            VisitorDto visitorDto = new VisitorDto();
            visitorDto.setId(visitor.getId());

            Worker worker = visitor.getWorker();
            if (worker != null) {
                WorkerDto workerDto = new WorkerDto();
                workerDto.setId(worker.getId());
                workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
                workerDto.setCargTrabajador(worker.getCargTrabajador());
                workerDto.setEmpTrabajador(worker.getEmpTrabajador());
                visitorDto.setWorker(workerDto);

                User user = worker.getUser();
                if (user != null) {
                    workerDto.setUserName(user.getNombre());
                    workerDto.setUserCedula(user.getCedula());
                }
            }
            Parking parking = visitor.getParking();
            if (parking != null) {
                ParkingDto parkingDto = new ParkingDto();
                parkingDto.setId(parking.getId());
                parkingDto.setTipoParqueadero(parking.getTipoParqueadero());
                parkingDto.setEstadoParqueadero(parking.getEstadoParqueadero());
                parkingDto.setFecParqueadero(parking.getFecParqueadero());
                parkingDto.setDvteParqueadero(parking.getDvteParqueadero());
                parkingDto.setCupParqueadero(parking.getCupParqueadero());
                parkingDto.setHoraSalida(parking.getHoraSalida());
                parkingDto.setCostParqueadero(parking.getCostParqueadero());
                visitorDto.setParking(parkingDto);
            }
            Property property = visitor.getProperty();
            if (property != null) {
                PropertyDto propertyDto = new PropertyDto();
                propertyDto.setId(property.getId());
                propertyDto.setAndInmueble(property.getAndInmueble());
                propertyDto.setNumInmueble(property.getNumInmueble());
                visitorDto.setProperty(propertyDto);
            }
            visitorDto.setNomVisitante(visitor.getNomVisitante());
            visitorDto.setTipoDoc(visitor.getTipoDoc());
            visitorDto.setCedula(visitor.getCedula());
            visitorDto.setNomResidente(visitor.getNomResidente());
            visitorDto.setCarVisitante(visitor.getCarVisitante());
            visitorDto.setIngrVisitante(visitor.getIngrVisitante());
            visitorDto.setFecVisitante(visitor.getFecVisitante());
            visitorDtoList.add(visitorDto);

        });
        return visitorDtoList;
    }

    //POST
    public VisitorDto create(VisitorDto visitorDto) throws Exception {
        Visitor visitor = new Visitor();
        visitor.setNomVisitante(visitorDto.getNomVisitante());
        visitor.setTipoDoc(visitorDto.getTipoDoc());
        visitor.setCedula(visitorDto.getCedula());
        visitor.setNomResidente(visitorDto.getNomResidente());
        visitor.setCarVisitante(visitorDto.getCarVisitante());
        visitor.setIngrVisitante(visitorDto.getIngrVisitante());
        visitor.setFecVisitante(visitorDto.getFecVisitante());

        WorkerDto workerDto = visitorDto.getWorker();
        if (workerDto != null) {
            Worker worker = workerService.findById(workerDto.getId());
            if (worker == null) {
                throw new Exception("Worker not found");
            }
            visitor.setWorker(worker);
        }
        ParkingDto parkingDto = visitorDto.getParking();
        if (parkingDto != null) {
            Parking parking = parkingService.findById(parkingDto.getId());
            visitor.setParking(parking);
        } else {
            visitor.setParking(null);
        }
        PropertyDto propertyDto = visitorDto.getProperty();
        if (propertyDto != null) {
            Property property = propertyService.findById(propertyDto.getId());
            if (property == null) {
                throw new Exception("Property not found");
            }
            visitor.setProperty(property);
        }

        Visitor createdVisitor = visitorService.create(visitor);

        VisitorDto createdVisitorDto = new VisitorDto();
        createdVisitorDto.setId(createdVisitor.getId());
        createdVisitorDto.setNomVisitante(createdVisitor.getNomVisitante());
        createdVisitorDto.setTipoDoc(createdVisitor.getTipoDoc());
        createdVisitorDto.setCedula(createdVisitor.getCedula());
        createdVisitorDto.setNomResidente(createdVisitor.getNomResidente());
        createdVisitorDto.setCarVisitante(createdVisitor.getCarVisitante());
        createdVisitorDto.setIngrVisitante(createdVisitor.getIngrVisitante());
        createdVisitorDto.setFecVisitante(createdVisitor.getFecVisitante());


        Worker worker = createdVisitor.getWorker();
        if (worker != null) {
            WorkerDto createdWorkerDto = new WorkerDto();
            createdWorkerDto.setId(worker.getId());
            createdWorkerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
            createdWorkerDto.setCargTrabajador(worker.getCargTrabajador());
            createdWorkerDto.setEmpTrabajador(worker.getEmpTrabajador());

            User user = worker.getUser();
            if (user != null) {
                createdWorkerDto.setUserName(user.getNombre());
                createdWorkerDto.setUserCedula(user.getCedula());
            }

            createdVisitorDto.setWorker(createdWorkerDto);
        }

        Parking parking = createdVisitor.getParking();
        if (parking != null) {
            ParkingDto createdParkingDto = new ParkingDto();
            createdParkingDto.setId(parking.getId());
            createdParkingDto.setTipoParqueadero(parking.getTipoParqueadero());
            createdParkingDto.setEstadoParqueadero(parking.getEstadoParqueadero());
            createdParkingDto.setFecParqueadero(parking.getFecParqueadero());
            createdParkingDto.setDvteParqueadero(parking.getDvteParqueadero());
            createdParkingDto.setCupParqueadero(parking.getCupParqueadero());
            createdParkingDto.setHoraSalida(parking.getHoraSalida());
            //createdParkingDto.setTarParqueadero(parking.getTarParqueadero());
            createdParkingDto.setCostParqueadero(parking.getCostParqueadero());
            createdVisitorDto.setParking(createdParkingDto);
        }

        Property property = createdVisitor.getProperty();
        if (property != null) {
            PropertyDto createdPropertyDto = new PropertyDto();
            createdPropertyDto.setId(property.getId());
            createdPropertyDto.setAndInmueble(property.getAndInmueble());
            createdPropertyDto.setNumInmueble(property.getNumInmueble());
            createdVisitorDto.setProperty(createdPropertyDto);
        }

        return createdVisitorDto;
    }


    //PUT
    public void update(VisitorDto visitorDto, int id) throws Exception {
        Visitor existingVisitor = visitorService.findById(id);
        if (existingVisitor == null) {
            throw new Exception("Visitor not found");
        }
        existingVisitor.setNomVisitante(visitorDto.getNomVisitante());
        existingVisitor.setTipoDoc(visitorDto.getTipoDoc());
        existingVisitor.setCedula(visitorDto.getCedula());
        existingVisitor.setNomResidente(visitorDto.getNomResidente());
        existingVisitor.setCarVisitante(visitorDto.getCarVisitante());
        existingVisitor.setIngrVisitante(visitorDto.getIngrVisitante());
        existingVisitor.setFecVisitante(visitorDto.getFecVisitante());

        WorkerDto workerDto = visitorDto.getWorker();
        if (workerDto != null) {
            Worker worker = workerService.findById(workerDto.getId());
            if (worker == null) {
                throw new Exception("Worker not found");
            }
            existingVisitor.setWorker(worker);
        }
        ParkingDto parkingDto = visitorDto.getParking();
        if (parkingDto != null) {
            Parking parking = parkingService.findById(parkingDto.getId());
            if (parking == null) {
                throw new Exception("Parking not found");
            }
            existingVisitor.setParking(parking);
        } else {
            existingVisitor.setParking(null);
        }
        PropertyDto propertyDto = visitorDto.getProperty();
        if (propertyDto != null) {
            Property property = propertyService.findById(propertyDto.getId());
            if (property == null) {
                throw new Exception("Property not found");
            }
            existingVisitor.setProperty(property);
        } else {
            existingVisitor.setProperty(null);
        }

        visitorService.update(existingVisitor);
    }
    public void delete(int id) throws Exception {
        Visitor existingVisitor = visitorService.findById(id);
        if (existingVisitor == null) {
            throw new Exception("Visitor not found");
        }
    }
}
