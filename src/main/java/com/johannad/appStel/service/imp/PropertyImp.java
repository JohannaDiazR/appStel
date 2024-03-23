package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.Property;
import com.johannad.appStel.repository.PropertyRepository;
import com.johannad.appStel.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyImp implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    private List<Property> propertyList;

    @Override
    public List<Property> findAll()throws Exception{
        this.propertyList=this.propertyRepository.findAll();
        return this.propertyList;

    }

    @Override
    public Property findById(int id){
        Property property=this.propertyRepository.findById(id);
        return property;
    }

    @Override
    public Property create(Property property){
        this.propertyRepository.save(property);
        return property;
    }

    @Override
    public void update(Property property){
        this.propertyRepository.save(property);
    }

    @Override
    public void delete(Property property){
        this.propertyRepository.delete(property);
    }
}
