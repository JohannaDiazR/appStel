package com.johannad.appStel.business;

import com.johannad.appStel.dtos.*;
import com.johannad.appStel.entity.*;
import com.johannad.appStel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResidentBusiness {
    @Autowired
    private ResidentService residentService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private UserService userService;

    private List<Resident> residentList;

    // Método para encontrar todos los residentes
    public List<ResidentDto> findAll() throws Exception {
        this.residentList = this.residentService.findAll();
        List<ResidentDto> residentDtoList = new ArrayList<>();

        this.residentList.forEach(resident -> {
            ResidentDto residentDto = new ResidentDto();
            residentDto.setId(resident.getId());
            residentDto.setNumIntegrantes(resident.getNumIntegrantes());

            // Asignar información de Parking
            Parking parking = resident.getParking();
            if (parking != null) {
                ParkingDto parkingDto = new ParkingDto();
                parkingDto.setId(parking.getId());
                parkingDto.setTipoParqueadero(parking.getTipoParqueadero());
                parkingDto.setEstadoParqueadero(parking.getEstadoParqueadero());
                parkingDto.setFecParqueadero(parking.getFecParqueadero());
                parkingDto.setDvteParqueadero(parking.getDvteParqueadero());
                parkingDto.setCupParqueadero(parking.getCupParqueadero());
                parkingDto.setHoraSalida(parking.getHoraSalida());
                //parkingDto.setTarParqueadero(parking.getTarParqueadero());
                parkingDto.setCostParqueadero(parking.getCostParqueadero());
                residentDto.setParking(parkingDto);
            }

            // Asignar información de Role
            Role role = resident.getRole();
            if (role != null) {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(role.getId());
                roleDto.setNombreRol(role.getNombreRol());
                residentDto.setRole(roleDto);
            }

            // Asignar información de User
            User user = resident.getUser();
            if (user != null) {
                // Llenar UserDto
                UserDto userDto = new UserDto();
                userDto.setId(user.getId());
                userDto.setUsuario(user.getUsuario());
                userDto.setContrasena(user.getContrasena());
                userDto.setNombre(user.getNombre());
                userDto.setCedula(user.getCedula());
                userDto.setCelular(user.getCelular());
                residentDto.setUser(userDto);

                // Llenar campos específicos en ResidentDto
                residentDto.setUserName(user.getNombre());
                residentDto.setUserCedula(user.getCedula());
            } else {
                // Manejo cuando user es null
                residentDto.setUser(null);
                residentDto.setUserName(null);
                residentDto.setUserCedula(0);
            }

            // Añadir el ResidentDto a la lista de resultados
            residentDtoList.add(residentDto);
        });

        return residentDtoList;
    }
    //POST
    public ResidentDto create(ResidentDto residentDto) throws Exception {
        Resident resident = new Resident();
        resident.setNumIntegrantes(residentDto.getNumIntegrantes());

        ParkingDto parkingDto = residentDto.getParking();
        if (parkingDto != null) {
            Parking parking = parkingService.findById(parkingDto.getId());
            resident.setParking(parking);
        } else {
            // Si el parqueadero es nulo, puedes asignar null directamente al campo
            resident.setParking(null);

        }

        RoleDto roleDto = residentDto.getRole();
        if (roleDto != null) {
            Role role = roleService.findById(roleDto.getId());

            resident.setRole(role);
        }
        UserDto userDto = residentDto.getUser();
        if (userDto != null) {
            User user = userService.findById(userDto.getId());
            if (user == null) {
                throw new Exception("User not found");
            }
            resident.setUser(user);
        }
        Resident createdResident = residentService.create(resident);

        ResidentDto createdResidentDto = new ResidentDto();
        createdResidentDto.setId(createdResident.getId());
        createdResidentDto.setNumIntegrantes(createdResident.getNumIntegrantes());

        Parking parking = createdResident.getParking();
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
            createdResidentDto.setParking(createdParkingDto);
        }
        Role role = createdResident.getRole();
        if (role != null) {
            RoleDto createdRoleDto = new RoleDto();
            createdRoleDto.setId(role.getId());
            createdRoleDto.setNombreRol(role.getNombreRol());
            createdResidentDto.setRole(createdRoleDto);
        }

        User user = createdResident.getUser();
        if (user != null) {
            UserDto createdUserDto = new UserDto();
            createdUserDto.setId(user.getId());
            createdUserDto.setUsuario(user.getUsuario());
            createdUserDto.setContrasena(user.getContrasena());
            createdUserDto.setNombre(user.getNombre());
            createdUserDto.setCedula(user.getCedula());
            createdUserDto.setCelular(user.getCelular());
            createdResidentDto.setUser(createdUserDto);
        }

        return createdResidentDto;
    }
        //PUT
        public void update(ResidentDto residentDto, int id) throws Exception {
            Resident existingResident = residentService.findById(id);
            if (existingResident == null) {
                throw new Exception("Resident not found");
            }
            existingResident.setNumIntegrantes(residentDto.getNumIntegrantes());

            ParkingDto parkingDto = residentDto.getParking();
            if (parkingDto != null) {
                Parking parking = parkingService.findById(parkingDto.getId());
                if (parking == null) {
                    throw new Exception("Parking not found");
                }
                existingResident.setParking(parking);
            } else {
                existingResident.setParking(null);
            }

            RoleDto roleDto = residentDto.getRole();
            if (roleDto != null) {
                Role role = roleService.findById(roleDto.getId());
                if (role == null) {
                    throw new Exception("Role not found");
                }
                existingResident.setRole(role);
            }
            UserDto userDto = residentDto.getUser();
            if (userDto != null) {
                User user = userService.findById(userDto.getId());
                if (user == null) {
                    throw new Exception("User not found");
                }
            }

            residentService.update(existingResident);
        }
    public void delete(int id) throws Exception {
        Resident existingResident = residentService.findById(id);
        if (existingResident == null) {
            throw new Exception("Resident not found");
        }

        residentService.delete(existingResident);
    }
}

