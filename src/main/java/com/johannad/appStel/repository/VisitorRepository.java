package com.johannad.appStel.repository;

import com.johannad.appStel.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
    @Query(value = "SELECT v From Visitor v WHERE v.id= :id")
    public Visitor findById(int id);
}
