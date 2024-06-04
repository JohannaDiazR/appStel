package com.johannad.appStel.business;

import com.johannad.appStel.dtos.*;
import com.johannad.appStel.entity.*;
import com.johannad.appStel.service.RoleService;
import com.johannad.appStel.service.VisitorService;
import com.johannad.appStel.service.WalletStatusService;
import com.johannad.appStel.service.WorkerService;
import com.sun.jdi.PrimitiveValue;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component

public class WorkerBusiness {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private RoleService roleService;

    private List<Worker> workerList;


    public List<WorkerDto> findAll() throws Exception {
        this.workerList = this.workerService.findAll();
        List<WorkerDto> workerDtoList = new ArrayList<>();
        this.workerList.forEach(worker -> {
            WorkerDto workerDto = new WorkerDto();
            workerDto.setId(worker.getId());

            Role role = worker.getRole();
            if (role != null){
                RoleDto roleDto = new RoleDto();
                roleDto.setId(role.getId());
                roleDto.setNombreRol(role.getNombreRol());
                workerDto.setRole(roleDto);
            }
            User user = worker.getUser();
            if (user != null){
                UserDto userDto = new UserDto();
                userDto.setId(user.getId());
                userDto.setUsuario(user.getUsuario());
                userDto.setContrasena(user.getContrasena());
                userDto.setNombre(user.getNombre());
                userDto.setCedula(user.getCedula());
                userDto.setCelular(user.getCelular());
                workerDto.setUser(userDto);
            }

            workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
            workerDto.setCargTrabajador(worker.getCargTrabajador());
            workerDto.setEmpTrabajador(worker.getEmpTrabajador());
            workerDtoList.add(workerDto);
        });
        return workerDtoList;
    }
    //POST
    public WorkerDto create(WorkerDto workerDto) throws Exception {
        Worker worker = new Worker();
        worker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
        worker.setCargTrabajador(workerDto.getCargTrabajador());
        worker.setEmpTrabajador(workerDto.getEmpTrabajador());

        RoleDto roleDto = workerDto.getRole();
        if (roleDto != null) {
            Role role = new Role();
            role.setId(roleDto.getId());
            role.setNombreRol(roleDto.getNombreRol());
            worker.setRole(role);
        }
        UserDto userDto = workerDto.getUser();
        if (userDto != null) {
            User user = new User();
            user.setId(userDto.getId());
            user.setUsuario(userDto.getUsuario());
            user.setContrasena(userDto.getContrasena());
            user.setNombre(userDto.getNombre());
            user.setCedula(userDto.getCedula());
            user.setCelular(userDto.getCelular());
            worker.setUser(user);
        }

        Worker createdWorker = workerService.create(worker);
        WorkerDto createdWorkerDto = new WorkerDto();
        createdWorkerDto.setId(createdWorker.getId());

        Role createdRole = createdWorker.getRole();
        if (createdRole != null) {
            RoleDto createdRoleDto = new RoleDto();
            createdRoleDto.setId(createdRole.getId());
            createdRoleDto.setNombreRol(createdRole.getNombreRol());
            createdWorkerDto.setRole(createdRoleDto);
        }
        UserDto createdUserDto = new UserDto();
        User createdUser = createdWorker.getUser();
        if (createdUser != null) {
            createdUserDto.setId(createdUser.getId());
            createdUserDto.setUsuario(createdUser.getUsuario());
            createdUserDto.setContrasena(createdUser.getContrasena());
            createdUserDto.setNombre(createdUser.getNombre());
            createdUserDto.setCedula(createdUser.getCedula());
            createdUserDto.setCelular(createdUser.getCelular());
            createdWorkerDto.setUser(createdUserDto);
        }

        createdWorkerDto.setTpcoTrabajador(createdWorker.getTpcoTrabajador());
        createdWorkerDto.setCargTrabajador(createdWorker.getCargTrabajador());
        createdWorkerDto.setEmpTrabajador(createdWorker.getEmpTrabajador());

        return createdWorkerDto;
    }
    //PUT
    public void update(WorkerDto workerDto, int id) throws Exception {
        Worker existingWorker = workerService.findById(id);
        if (existingWorker == null) {
            throw new Exception("Worker not found");
        }

        existingWorker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
        existingWorker.setCargTrabajador(workerDto.getCargTrabajador());
        existingWorker.setEmpTrabajador(workerDto.getEmpTrabajador());

        RoleDto roleDto = workerDto.getRole();
        if (roleDto != null) {
            Role existingRole = existingWorker.getRole();
            if (existingRole == null) {
                existingRole = new Role();
            }
            existingRole.setId(roleDto.getId());
            existingRole.setNombreRol(roleDto.getNombreRol());
            existingWorker.setRole(existingRole);
        }
        UserDto userDto = workerDto.getUser();
        if (userDto != null) {
            User existingUser = existingWorker.getUser();
            if (existingUser == null){
                existingUser = new User();
            }
            existingUser.setId(userDto.getId());
            existingUser.setUsuario(userDto.getUsuario());
            existingUser.setContrasena(userDto.getContrasena());
            existingUser.setNombre(userDto.getNombre());
            existingUser.setCedula(userDto.getCedula());
            existingUser.setCelular(userDto.getCelular());
            existingWorker.setUser(existingUser);
        }

        workerService.update(existingWorker);
    }

    public void delete(int id) throws Exception {
        Worker existingWorker = workerService.findById(id);
        if (existingWorker == null) {
            throw new Exception("Worker not found");
        }

        workerService.delete(existingWorker);
    }
}
