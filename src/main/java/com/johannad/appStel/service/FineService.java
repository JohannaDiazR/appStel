package com.johannad.appStel.service;

import com.johannad.appStel.entity.Fine;

import java.util.List;

public interface FineService {
    public List<Fine> findAll() throws Exception;
    public Fine findById(int id);
    public Fine create(Fine fine);
    public void update(Fine fine);
    public void delete(Fine fine);
}
