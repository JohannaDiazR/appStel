package com.johannad.appStel.repository;

import com.johannad.appStel.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    @Query(value = "SELECT w From Worker w WHERE w.id= :id")
    public Worker findById(int id);
}
