package com.johannad.appStel.repository;

import com.johannad.appStel.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    @Query(value = "SELECT pr From Property pr WHERE pr.id= :id")
    public Property findById(int id);
}
