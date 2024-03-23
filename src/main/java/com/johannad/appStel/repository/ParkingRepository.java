package com.johannad.appStel.repository;

import com.johannad.appStel.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
    @Query(value = "SELECT p From Parking p WHERE p.id= :id")
    public Parking findById(int id);
}
