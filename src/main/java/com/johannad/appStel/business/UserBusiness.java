package com.johannad.appStel.business;

import com.johannad.appStel.dtos.*;
import com.johannad.appStel.entity.*;
import com.johannad.appStel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserBusiness {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResidentService residentService;
    @Autowired
    private WorkerService workerService;


    private List<User> userList;


    public List<UserDto> findAll() throws Exception {
        this.userList = this.userService.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        this.userList.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());

            Role role = user.getRole();
            if (role != null) {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(role.getId());
                roleDto.setNombreRol(role.getNombreRol());
                userDto.setRole(roleDto);
            }

            Resident resident = user.getResident();
            if (resident != null) {
                ResidentDto residentDto = new ResidentDto();
                residentDto.setId(resident.getId());
                residentDto.setNumIntegrantes(resident.getNumIntegrantes());
                userDto.setResident(residentDto);
            }
            Worker worker = user.getWorker();
            if (worker != null) {
                WorkerDto workerDto = new WorkerDto();
                workerDto.setId(worker.getId());
                workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
                workerDto.setCargTrabajador(worker.getCargTrabajador());
                workerDto.setEmpTrabajador(worker.getEmpTrabajador());
                userDto.setWorker(workerDto);
            }


            userDto.setUsuario(user.getUsuario());
            userDto.setContrasena(user.getContrasena());
            userDto.setNombre(user.getNombre());
            userDto.setCedula(user.getCedula());
            userDto.setCelular(user.getCelular());
            userDtoList.add(userDto);
        });
        return userDtoList;
    }


    public UserDto create(UserDto userDto) throws Exception {
        User user = new User();
        user.setUsuario(userDto.getUsuario());
        user.setContrasena(userDto.getContrasena());
        user.setNombre(userDto.getNombre());
        user.setCedula(userDto.getCedula());
        user.setCelular(userDto.getCelular());


        RoleDto roleDto = userDto.getRole();
        if (roleDto != null) {
            Role role = roleService.findById(roleDto.getId());
            if (role == null) {
                throw new Exception("Role not found");
            }
            user.setRole(role);
        }

        ResidentDto residentDto = userDto.getResident();
        if (residentDto != null) {
            Resident resident = residentService.findById(residentDto.getId());
            if (resident == null) {
                throw new Exception("Resident not found");
            }
            user.setResident(resident);
        }

        WorkerDto workerDto = userDto.getWorker();
        if (workerDto != null){
            Worker worker = workerService.findById(workerDto.getId());
            if (worker == null){
                throw new Exception("Worker not found");
            }
            user.setWorker(worker);
        }


        User createdUser = userService.create(user);
        UserDto createdUserDto = new UserDto();
        createdUserDto.setId(createdUser.getId());
        createdUserDto.setUsuario(createdUser.getUsuario());
        createdUserDto.setContrasena(createdUser.getContrasena());
        createdUserDto.setNombre(createdUser.getNombre());
        createdUserDto.setCedula(createdUser.getCedula());
        createdUserDto.setCelular(createdUser.getCelular());

        Role role = createdUser.getRole();
        if (role != null) {
            RoleDto createdRoleDto = new RoleDto();
            createdRoleDto.setId(role.getId());
            createdRoleDto.setNombreRol(role.getNombreRol());
            createdUserDto.setRole(createdRoleDto);
        }

        Resident resident = createdUser.getResident();
        if (resident != null) {
            ResidentDto createdResidentDto = new ResidentDto();
            createdResidentDto.setId(resident.getId());
            createdResidentDto.setNumIntegrantes(resident.getNumIntegrantes());
            createdUserDto.setResident(createdResidentDto);
        }
        Worker worker = createdUser.getWorker();
        if (worker != null) {
            WorkerDto createdWorkerDto = new WorkerDto();
            createdWorkerDto.setId(worker.getId());
            createdWorkerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
            createdWorkerDto.setCargTrabajador(worker.getCargTrabajador());
            createdWorkerDto.setEmpTrabajador(worker.getEmpTrabajador());
            createdUserDto.setWorker(createdWorkerDto);
        }


        return createdUserDto;
    }


    public void update(UserDto userDto, int id) throws Exception {
        User existingUser = userService.findById(id);
        if (existingUser == null) {
            throw new Exception("User not found");
        }
        existingUser.setUsuario(userDto.getUsuario());
        existingUser.setContrasena(userDto.getContrasena());
        existingUser.setNombre(userDto.getNombre());
        existingUser.setCedula(userDto.getCedula());
        existingUser.setCelular(userDto.getCelular());

        // Manejo del rol
        RoleDto roleDto = userDto.getRole();
        if (roleDto != null) {
            Role role = roleService.findById(roleDto.getId());
            if (role == null) {
                throw new Exception("Role not found");
            }
            existingUser.setRole(role);
        }


        ResidentDto residentDto = userDto.getResident();
        if (residentDto != null) {
            Resident resident = residentService.findById(residentDto.getId());
            if (resident == null) {
                throw new Exception("Resident not found");
            }
            existingUser.setResident(resident);
        }
        WorkerDto workerDto = userDto.getWorker();
        if (workerDto != null) {
            Worker worker = workerService.findById(workerDto.getId());
            if (worker == null) {
                throw new Exception("Worker not found");
            }
            existingUser.setWorker(worker);
        }


        userService.update(existingUser);
    }


    public void delete(int id) throws Exception {
        User existingUser = userService.findById(id);
        if (existingUser == null) {
            throw new Exception("User not found");
        }

        userService.delete(existingUser);
    }
}
