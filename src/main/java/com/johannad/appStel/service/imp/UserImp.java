package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.User;
import com.johannad.appStel.repository.UserRepository;
import com.johannad.appStel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    private List<User> userList;

    @Override
    public List<User> findAll()throws Exception{
        this.userList=this.userRepository.findAll();
        return this.userList;

    }

    @Override
    public User findById(int id){
        User user=this.userRepository.findById(id);
        return user;
    }

    @Override
    public User create(User user){
        this.userRepository.save(user);
        return user;
    }

    @Override
    public void update(User user){
        this.userRepository.save(user);
    }

    @Override
    public void delete(User user){
        this.userRepository.delete(user);
    }
}
