package com.johannad.appStel.service;

import com.johannad.appStel.entity.Visitor;

import java.util.List;

public interface VisitorService {
    public List<Visitor> findAll() throws Exception;

    public Visitor findById(int id);

    public Visitor create(Visitor visitor);

    public void update(Visitor visitor);

    public void delete(Visitor visitor);


}
