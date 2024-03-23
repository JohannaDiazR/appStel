package com.johannad.appStel.repository;

import com.johannad.appStel.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Integer> {
    @Query(value = "SELECT re From Resident re WHERE re.id= :id")
    public Resident findById(int id);
}
