package com.johannad.appStel.business;

import com.johannad.appStel.dtos.*;
import com.johannad.appStel.entity.*;
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
    private ParkingService parkingService;
    @Autowired
    private PropertyService propertyService;

    private List<Visitor> visitorList;

    public List<VisitorDto> findAll() throws Exception {
        this.visitorList = this.visitorService.findAll();
        List<VisitorDto> visitorDtoList = new ArrayList<>();
        this.visitorList.forEach(visitor -> {
            VisitorDto visitorDto = new VisitorDto();
            visitorDto.setId(visitor.getId());

            Worker worker = visitor.getWorker();
            if (worker != null){
                WorkerDto workerDto = new WorkerDto();
                workerDto.setId(worker.getId());
                workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
                workerDto.setCargTrabajador(worker.getCargTrabajador());
                workerDto.setEmpTrabajador(worker.getEmpTrabajador());
                visitorDto.setWorker(workerDto);
            }
            Parking parking = visitor.getParking();
            if (parking != null) {
                ParkingDto parkingDto = new ParkingDto();
                parkingDto .setId(parking.getId());
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
            if (property != null) {
                PropertyDto propertyDto = new PropertyDto();
                propertyDto.setId(property.getId());
                propertyDto.setAndInmueble(property.getAndInmueble());
                propertyDto.setNumInmueble(property.getNumInmueble());
                visitorDto.setProperty(propertyDto);
            }
            User user = visitor.getUser();
            if (user != null) {
                UserDto userDto = new UserDto();
                userDto.setId(user.getId());
                userDto.setUsuario(user.getUsuario());
                userDto.setContrasena(user.getContrasena());
                userDto.setNombre(user.getNombre());
                userDto.setCedula(user.getCedula());
                userDto.setCelular(user.getCelular());
                visitorDto.setUser(userDto);
            }

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
        visitor.setNomResidente(visitorDto.getNomResidente());
        visitor.setCarVisitante(visitorDto.getCarVisitante());
        visitor.setIngrVisitante(visitorDto.getIngrVisitante());
        visitor.setFecVisitante(visitorDto.getFecVisitante());

        WorkerDto workerDto = visitorDto.getWorker();
        if (workerDto != null) {
            Worker worker = new Worker();
            worker.setId(workerDto.getId());
            worker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
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
            visitor.setParking(parking);
        }
        PropertyDto propertyDto = visitorDto.getProperty();
        if (propertyDto != null) {
            Property property = new Property();
            property.setId(propertyDto.getId());
            property.setAndInmueble(propertyDto.getAndInmueble());
            property.setNumInmueble(propertyDto.getNumInmueble());
            visitor.setProperty(property);
        }
        UserDto userDto = visitorDto.getUser();
        if (userDto != null) {
            User user = new User();
            user.setId(userDto.getId());
            user.setUsuario(userDto.getUsuario());
            user.setContrasena(userDto.getContrasena());
            user.setNombre(userDto.getNombre());
            user.setCedula(userDto.getCedula());
            user.setCelular(userDto.getCelular());
            visitor.setUser(user);
        }
        Visitor createdVisitor = visitorService.create(visitor);

        VisitorDto createdVisitorDto = new VisitorDto();
        createdVisitorDto.setId(createdVisitor.getId());

        WorkerDto createdWorkerDto = new WorkerDto();
        Worker createdWorker = createdVisitor.getWorker();
        if (createdWorker != null) {
            createdWorkerDto.setId(createdWorker.getId());
            createdWorkerDto.setTpcoTrabajador(createdWorker.getTpcoTrabajador());
            createdWorkerDto.setCargTrabajador(createdWorker.getCargTrabajador());
            createdWorkerDto.setEmpTrabajador(createdWorker.getEmpTrabajador());
            createdVisitorDto.setWorker(workerDto);
        }
        ParkingDto createdParkingDto = new ParkingDto();
        Parking createdParking = createdVisitor.getParking();
        if (createdParking != null) {
            createdParkingDto.setId(createdParking.getId());
            createdParkingDto.setTipoParqueadero(createdParking.getTipoParqueadero());
            createdParkingDto.setEstadoParqueadero(createdParking.getEstadoParqueadero());
            createdParkingDto.setFecParqueadero(createdParking.getFecParqueadero());
            createdParkingDto.setDvteParqueadero(createdParking.getDvteParqueadero());
            createdParkingDto.setCupParqueadero(createdParking.getCupParqueadero());
            createdParkingDto.setHoraSalida(createdParking.getHoraSalida());
            createdParkingDto.setTarParqueadero(createdParking.getTarParqueadero());
            createdVisitorDto.setParking(createdParkingDto);
        }
        PropertyDto createdPropertyDto = new PropertyDto();
        Property createdProperty = createdVisitor.getProperty();
        if (createdProperty != null) {
            createdPropertyDto.setId(createdProperty.getId());
            createdPropertyDto.setAndInmueble(createdProperty.getAndInmueble());
            createdPropertyDto.setNumInmueble(createdProperty.getNumInmueble());
            createdVisitorDto.setProperty(createdPropertyDto);
        }
        UserDto createdUserDto = new UserDto();
        User createdUser = createdVisitor.getUser();
        if (createdUser != null) {
            createdUserDto.setId(createdUser.getId());
            createdUserDto.setUsuario(createdUser.getUsuario());
            createdUserDto.setContrasena(createdUser.getContrasena());
            createdUserDto.setNombre(createdUser.getNombre());
            createdUserDto.setCedula(createdUser.getCedula());
            createdUserDto.setCelular(createdUser.getCelular());
            createdVisitorDto.setUser(createdUserDto);
        }

        createdVisitorDto.setNomResidente(createdVisitor.getNomResidente());
        createdVisitorDto.setCarVisitante(createdVisitor.getCarVisitante());
        createdVisitorDto.setIngrVisitante(createdVisitor.getIngrVisitante());
        createdVisitorDto.setFecVisitante(createdVisitor.getFecVisitante());

        return createdVisitorDto;
    }
    //PUT
    public void  update(VisitorDto visitorDto, int id) throws Exception {
        Visitor existingVisitor = visitorService.findById(id);
        if (existingVisitor == null) {
            throw new Exception("Visitor not found");
        }

        existingVisitor.setNomResidente(visitorDto.getNomResidente());
        existingVisitor.setCarVisitante(visitorDto.getCarVisitante());
        existingVisitor.setIngrVisitante(visitorDto.getIngrVisitante());
        existingVisitor.setFecVisitante(visitorDto.getFecVisitante());

        WorkerDto workerDto = visitorDto.getWorker();
        if (workerDto != null) {
            Worker existingWorker = existingVisitor.getWorker();
            if (existingWorker == null) {
                existingWorker = new Worker();
            }
            existingWorker.setId(workerDto.getId());
            existingWorker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
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
        UserDto userDto = visitorDto.getUser();
        if (userDto != null) {
            User existingUser = existingVisitor.getUser();
            if (existingUser == null){
                existingUser = new User();
            }
            existingUser.setId(userDto.getId());
            existingUser.setUsuario(userDto.getUsuario());
            existingUser.setContrasena(userDto.getContrasena());
            existingUser.setNombre(userDto.getNombre());
            existingUser.setCedula(userDto.getCedula());
            existingUser.setCelular(userDto.getCelular());
            existingVisitor.setUser(existingUser);
        }
        visitorService.update(existingVisitor);
    }
    public void delete(int id) throws Exception {
        Visitor existingVisitor = visitorService.findById(id);
        if (existingVisitor == null) {
            throw new Exception("Visitor not found");
        }

        visitorService.delete(existingVisitor);
    }

}