package com.johannad.appStel.service;

import com.johannad.appStel.entity.AdminDocs;

import java.util.List;

public interface AdminDocsService {
    public List<AdminDocs> findAll() throws Exception;

    public AdminDocs findById(int id);

    public AdminDocs create(AdminDocs admindocs);

    public void update(AdminDocs admindocs);

    public void delete(AdminDocs admindocs);
}
