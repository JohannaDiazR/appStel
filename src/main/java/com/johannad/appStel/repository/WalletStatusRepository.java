package com.johannad.appStel.repository;

import com.johannad.appStel.entity.WalletStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WalletStatusRepository extends JpaRepository<WalletStatus,Integer> {
    @Query(value= "select ws From WalletStatus ws where ws.id= :id")
    public WalletStatus findById(int id);
}
