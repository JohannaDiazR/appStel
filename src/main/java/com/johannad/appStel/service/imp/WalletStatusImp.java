package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.WalletStatus;
import com.johannad.appStel.repository.WalletStatusRepository;
import com.johannad.appStel.service.WalletStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletStatusImp implements WalletStatusService {
    @Autowired
    private WalletStatusRepository walletStatusRepository;

    private List<WalletStatus> walletStatusList;

    @Override
    public List<WalletStatus> findAll()throws Exception {
        this.walletStatusList=this.walletStatusRepository.findAll();
        return this.walletStatusList;
    }
    @Override
    public WalletStatus findById(int id) {
        WalletStatus walletStatus=this.walletStatusRepository.findById(id);
        return walletStatus;
    }
    @Override
    public WalletStatus create(WalletStatus walletStatus) {
        this.walletStatusRepository.save(walletStatus);
        return walletStatus;
    }
    @Override
    public void update(WalletStatus walletStatus){
        this.walletStatusRepository.save(walletStatus);
    }
    @Override
    public  void delete(WalletStatus walletStatus) {
        this.walletStatusRepository.delete(walletStatus);
    }

}
