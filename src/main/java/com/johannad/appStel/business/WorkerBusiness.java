package com.johannad.appStel.business;

import com.johannad.appStel.dtos.*;
import com.johannad.appStel.entity.*;
import com.johannad.appStel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkerBusiness {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    private List<Worker> workerList;

    public List<WorkerDto> findAll() throws Exception {
        this.workerList = this.workerService.findAll();
        List<WorkerDto> workerDtoList = new ArrayList<>();
        this.workerList.forEach(worker -> {
            WorkerDto workerDto = new WorkerDto();
            workerDto.setId(worker.getId());

            Role role = worker.getRole();
            if (role != null) {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(role.getId());
                roleDto.setNombreRol(role.getNombreRol());
                workerDto.setRole(roleDto);
            }

            User user = worker.getUser();
            if (user != null) {
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

    // POST
    public WorkerDto create(WorkerDto workerDto) throws Exception {
        Worker worker = new Worker();
        worker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
        worker.setCargTrabajador(workerDto.getCargTrabajador());
        worker.setEmpTrabajador(workerDto.getEmpTrabajador());

        RoleDto roleDto = workerDto.getRole();
        if (roleDto != null) {
            Role role = roleService.findById(roleDto.getId());
            worker.setRole(role);
        }

        UserDto userDto = workerDto.getUser();
        if (userDto != null) {
            User user = userService.findById(userDto.getId());
            if (user == null) {
                throw new Exception("User not found");
            }
            worker.setUser(user);
        }

        Worker createdWorker = workerService.create(worker);
        WorkerDto createdWorkerDto = new WorkerDto();
        createdWorkerDto.setId(createdWorker.getId());
        createdWorkerDto.setTpcoTrabajador(createdWorker.getTpcoTrabajador());
        createdWorkerDto.setCargTrabajador(createdWorker.getCargTrabajador());
        createdWorkerDto.setEmpTrabajador(createdWorker.getEmpTrabajador());

        Role role = createdWorker.getRole();
        if (role != null) {
            RoleDto createdRoleDto = new RoleDto();
            createdRoleDto.setId(role.getId());
            createdRoleDto.setNombreRol(role.getNombreRol());
            createdWorkerDto.setRole(createdRoleDto);
        }

        User user = createdWorker.getUser();
        if (user != null) {
            UserDto createdUserDto = new UserDto();
            createdUserDto.setId(user.getId());
            createdUserDto.setUsuario(user.getUsuario());
            createdUserDto.setContrasena(user.getContrasena());
            createdUserDto.setNombre(user.getNombre());
            createdUserDto.setCedula(user.getCedula());
            createdUserDto.setCelular(user.getCelular());
            createdWorkerDto.setUser(createdUserDto);
        }

        return createdWorkerDto;
    }

    // PUT
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
            Role role = roleService.findById(roleDto.getId());
            if (role == null) {
                throw new Exception("Role not found");
            }
            existingWorker.setRole(role);
        }

        UserDto userDto = workerDto.getUser();
        if (userDto != null) {
            User user = userService.findById(userDto.getId());
            if (user == null) {
                throw new Exception("User not found");
            }
            existingWorker.setUser(user);
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
