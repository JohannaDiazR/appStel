package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.AdminDocs;
import com.johannad.appStel.repository.AdminDocsRepository;
import com.johannad.appStel.service.AdminDocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDocsImp implements AdminDocsService {
    @Autowired
    private AdminDocsRepository adminDocsRepository;

    private List<AdminDocs> adminDocsList;

    @Override
    public List<AdminDocs> findAll(){return this.adminDocsRepository.findAll();}

    @Override
    public AdminDocs findById(int id){
        AdminDocs adminDocs=this.adminDocsRepository.findById(id);
        return adminDocs;
    }

    @Override
    public AdminDocs create(AdminDocs adminDocs){
        this.adminDocsRepository.save(adminDocs);
        return adminDocs;
    }

    @Override
    public void update(AdminDocs adminDocs){
        this.adminDocsRepository.save(adminDocs);
    }

    @Override
    public void delete(AdminDocs adminDocs){
        this.adminDocsRepository.delete(adminDocs);
    }


}
