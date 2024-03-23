package com.johannad.appStel.service;

import com.johannad.appStel.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll() throws Exception;

    public User findById(int id);

    User create(User user);

    void update(User user);

    void delete(User user);
}
