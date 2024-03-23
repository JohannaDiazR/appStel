package com.johannad.appStel.repository;

import com.johannad.appStel.entity.AdminDocs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDocsRepository extends JpaRepository<AdminDocs, Integer> {
    @Query(value = "SELECT ad From AdminDocs ad WHERE ad.id= :id")
    public AdminDocs findById(int id);
}
