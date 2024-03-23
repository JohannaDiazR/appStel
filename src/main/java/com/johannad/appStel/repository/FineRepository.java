package com.johannad.appStel.repository;

import com.johannad.appStel.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FineRepository extends JpaRepository<Fine,Integer> {
    @Query(value= "select f From Fine f where f.id= :id")
    public Fine findById(int id);
}
