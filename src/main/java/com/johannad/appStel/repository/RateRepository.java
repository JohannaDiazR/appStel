package com.johannad.appStel.repository;

import com.johannad.appStel.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {
    @Query(value = "SELECT ra FROM Rate ra WHERE ra.id= :id")
    public Rate findById(int id);
}
