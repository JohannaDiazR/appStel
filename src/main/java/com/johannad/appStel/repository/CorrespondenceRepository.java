package com.johannad.appStel.repository;

import com.johannad.appStel.entity.Correspondence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrespondenceRepository extends JpaRepository<Correspondence,Integer> {
    @Query(value= "SELECT c From Correspondence c WHERE c.id= :id")
    public Correspondence findById(int id);
}
