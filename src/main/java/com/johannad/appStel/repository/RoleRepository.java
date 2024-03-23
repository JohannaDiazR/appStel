package com.johannad.appStel.repository;

import com.johannad.appStel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value= "select r From Role r where r.id= :id")
    public Role findById(int id);
}
