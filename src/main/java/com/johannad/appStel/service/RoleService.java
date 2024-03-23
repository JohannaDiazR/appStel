package com.johannad.appStel.service;

import com.johannad.appStel.entity.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll() throws Exception;
    public Role findById(int id);
    public Role create(Role role);
    public void update(Role role);
    public void delete(Role role);
}
