package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.Role;
import com.johannad.appStel.repository.RoleRepository;
import com.johannad.appStel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private List<Role> roleList;

    @Override
    public List<Role> findAll()throws Exception {
        this.roleList=this.roleRepository.findAll();
        return this.roleList;
    }
    @Override
    public Role findById(int id) {
        Role role=this.roleRepository.findById(id);
        return role;
    }
    @Override
    public Role create(Role role) {
        this.roleRepository.save(role);
        return null;
    }
    @Override
    public void update(Role role){
        this.roleRepository.save(role);
    }
    @Override
    public  void delete(Role role) {
        this.roleRepository.delete(role);
    }
}
