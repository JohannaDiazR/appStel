package com.johannad.appStel.repository;

import com.johannad.appStel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u From User u WHERE u.id= :id")
    public User findById(int id);
}
