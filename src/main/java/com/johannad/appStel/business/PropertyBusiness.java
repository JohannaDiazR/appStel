package com.johannad.appStel.business;

import com.johannad.appStel.dtos.PropertyDto;
import com.johannad.appStel.dtos.ResidentDto;
import com.johannad.appStel.entity.Property;
import com.johannad.appStel.entity.Resident;
import com.johannad.appStel.entity.User;
import com.johannad.appStel.service.PropertyService;
import com.johannad.appStel.service.ResidentService;
import com.johannad.appStel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyBusiness {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ResidentService residentService;

    @Autowired
    private UserService userService;

    private List<Property> propertyList;

    public List<PropertyDto> findAll() throws Exception {
        this.propertyList = this.propertyService.findAll();
        List<PropertyDto> propertyDtoList = new ArrayList<>();

        for (Property property : this.propertyList) {
            PropertyDto propertyDto = new PropertyDto();
            propertyDto.setId(property.getId());
            propertyDto.setAndInmueble(property.getAndInmueble());
            propertyDto.setNumInmueble(property.getNumInmueble());

            Resident resident = property.getResident();
            if (resident != null) {
                ResidentDto residentDto = new ResidentDto();
                residentDto.setId(resident.getId());
                residentDto.setNumIntegrantes(resident.getNumIntegrantes());

                // Obtener el usuario asociado al residente
                User user = resident.getUser();
                if (user != null) {
                    residentDto.setUserName(user.getNombre());
                    residentDto.setUserCedula(user.getCedula());
                }

                propertyDto.setResident(residentDto);
            }

            propertyDtoList.add(propertyDto);
        }
        return propertyDtoList;
    }

    /**
     * Método para crear un nuevo inmueble con la información del residente y usuario asociados.
     */
    public PropertyDto create(PropertyDto propertyDto) throws Exception {
        Property property = new Property();
        property.setAndInmueble(propertyDto.getAndInmueble());
        property.setNumInmueble(propertyDto.getNumInmueble());

        ResidentDto residentDto = propertyDto.getResident();
        if (residentDto != null) {
            Resident resident = new Resident();
            resident.setId(residentDto.getId());
            resident.setNumIntegrantes(residentDto.getNumIntegrantes());

            // Buscar y asignar el usuario al residente si se proporciona ID o información relevante
            if (residentDto.getId() != 0) {
                User user = userService.findById(residentDto.getId()); // Ajusta esto según cómo obtienes el usuario
                if (user != null) {
                    resident.setUser(user);
                }
            }
            property.setResident(resident);
        }

        Property createdProperty = propertyService.create(property);
        PropertyDto createdPropertyDto = new PropertyDto();
        createdPropertyDto.setId(createdProperty.getId());
        createdPropertyDto.setAndInmueble(createdProperty.getAndInmueble());
        createdPropertyDto.setNumInmueble(createdProperty.getNumInmueble());

        Resident resident = createdProperty.getResident();
        if (resident != null) {
            residentDto = new ResidentDto();
            residentDto.setId(resident.getId());
            residentDto.setNumIntegrantes(resident.getNumIntegrantes());

            // Agregar información del usuario
            User user = resident.getUser();
            if (user != null) {
                residentDto.setUserName(user.getNombre());
                residentDto.setUserCedula(user.getCedula());
            }

            createdPropertyDto.setResident(residentDto);
        }
        return createdPropertyDto;
    }

    /**
     * Método para actualizar la información de un inmueble existente.
     */
    public void update(PropertyDto propertyDto, int id) throws Exception {
        Property existingProperty = propertyService.findById(id);
        if (existingProperty == null) {
            throw new Exception("Property not found");
        }

        existingProperty.setAndInmueble(propertyDto.getAndInmueble());
        existingProperty.setNumInmueble(propertyDto.getNumInmueble());

        ResidentDto residentDto = propertyDto.getResident();
        if (residentDto != null) {
            Resident existingResident = existingProperty.getResident();
            if (existingResident == null) {
                existingResident = new Resident();
            }
            existingResident.setId(residentDto.getId());
            existingResident.setNumIntegrantes(residentDto.getNumIntegrantes());

            User user = userService.findById(residentDto.getId());
            if (user != null) {
                existingResident.setUser(user);
            }

            existingProperty.setResident(existingResident);
        }

        propertyService.update(existingProperty);
    }

    /**
     * Método para eliminar un inmueble.
     */
    public void delete(int id) throws Exception {
        Property existingProperty = propertyService.findById(id);
        if (existingProperty == null) {
            throw new Exception("Property not found");
        }

        propertyService.delete(existingProperty);
    }
}
