package com.johannad.appStel.service;

import com.johannad.appStel.entity.Property;

import java.util.List;

public interface PropertyService {
    public List<Property> findAll() throws Exception;

    public Property findById(int id);

    public Property create(Property property);

    public void update(Property property);

    public void delete(Property property);
}
