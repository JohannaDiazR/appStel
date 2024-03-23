package com.johannad.appStel.service;

import com.johannad.appStel.entity.WalletStatus;

import java.util.List;

public interface WalletStatusService {
    public List<WalletStatus> findAll() throws Exception;
    public WalletStatus findById(int id);
    public WalletStatus create(WalletStatus walletStatus);
    public void update(WalletStatus walletStatus);
    public void delete(WalletStatus walletStatus);
}
