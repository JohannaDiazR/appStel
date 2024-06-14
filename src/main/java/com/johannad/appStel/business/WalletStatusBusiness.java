package com.johannad.appStel.business;

import com.johannad.appStel.dtos.PropertyDto;
import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.dtos.WorkerDto;
import com.johannad.appStel.entity.Property;
import com.johannad.appStel.entity.User;
import com.johannad.appStel.entity.WalletStatus;
import com.johannad.appStel.entity.Worker;
import com.johannad.appStel.service.PropertyService;
import com.johannad.appStel.service.UserService;
import com.johannad.appStel.service.WalletStatusService;
import com.johannad.appStel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WalletStatusBusiness {
    @Autowired
    private WalletStatusService walletStatusService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;
    //private List<WalletStatus> walletStatusList;



    public List<WalletStatusDto> findAll() throws Exception {
        //this.walletStatusList=this.walletStatusService.findAll();
        List<WalletStatus> walletStatusList = walletStatusService.findAll();
        List<WalletStatusDto> walletStatusDtoList = new ArrayList<>();

        for (WalletStatus walletStatus : walletStatusList){
            WalletStatusDto walletStatusDto = new WalletStatusDto();
            walletStatusDto.setId(walletStatus.getId());
            walletStatusDto.setEstcartera(walletStatus.getEstcartera());
            walletStatusDto.setFecestcartera(walletStatus.getFecestcartera());
            walletStatusDto.setNotiestcartera(walletStatus.getNotiestcartera());

            Property property = walletStatus.getProperty();
            if (property != null){
                PropertyDto propertyDto = new PropertyDto();
                propertyDto.setId(property.getId());
                propertyDto.setAndInmueble(property.getAndInmueble());
                propertyDto.setNumInmueble(property.getNumInmueble());
                walletStatusDto.setProperty(propertyDto);
            }
            Worker worker = walletStatus.getWorker();
            if (worker != null) {
                WorkerDto workerDto = new WorkerDto();
                workerDto.setId(worker.getId());
                workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
                workerDto.setCargTrabajador(worker.getCargTrabajador());
                workerDto.setEmpTrabajador(worker.getEmpTrabajador());

                User user = worker.getUser();
                if (user != null) {
                    workerDto.setUserName(user.getNombre());
                    workerDto.setUserCedula(user.getCedula());
                }
                walletStatusDto.setWorker(workerDto);
            }
            walletStatusDtoList.add(walletStatusDto);

        }
        return  walletStatusDtoList;

    }
    //POST
    public WalletStatusDto create(WalletStatusDto walletStatusDto) throws Exception {
        WalletStatus walletStatus = new WalletStatus();
        walletStatus.setEstcartera(walletStatusDto.getEstcartera());
        walletStatus.setFecestcartera(walletStatusDto.getFecestcartera());
        walletStatus.setNotiestcartera(walletStatusDto.getNotiestcartera());

        PropertyDto propertyDto = walletStatusDto.getProperty();
        if (propertyDto != null){
            Property property = propertyService.findById(propertyDto.getId());
            walletStatus.setProperty(property);
        }
        WorkerDto workerDto = walletStatusDto.getWorker();
        if (workerDto != null) {
            Worker worker = workerService.findById(workerDto.getId());
            if (worker != null) {
                walletStatus.setWorker(worker);
            }
        }

        WalletStatus createdWalletStatus = walletStatusService.create(walletStatus);
        WalletStatusDto createdWalletStatusDto = new WalletStatusDto();
        createdWalletStatusDto.setId(createdWalletStatus.getId());
        createdWalletStatusDto.setEstcartera(createdWalletStatus.getEstcartera());
        createdWalletStatusDto.setFecestcartera(createdWalletStatus.getFecestcartera());
        createdWalletStatusDto.setNotiestcartera(createdWalletStatus.getNotiestcartera());

        Property property = createdWalletStatus.getProperty();
        if (property != null) {
            PropertyDto propertyDtoResp = new PropertyDto();
            propertyDtoResp.setId(property.getId());
            propertyDtoResp.setAndInmueble(property.getAndInmueble());
            propertyDtoResp.setNumInmueble(property.getNumInmueble());
            createdWalletStatusDto.setProperty(propertyDtoResp);
        }
        Worker worker = createdWalletStatus.getWorker();
        if (worker != null) {
            WorkerDto workerDtoResp = new WorkerDto();
            workerDtoResp.setId(worker.getId());
            workerDtoResp.setTpcoTrabajador(worker.getTpcoTrabajador());
            workerDtoResp.setCargTrabajador(worker.getCargTrabajador());
            workerDtoResp.setEmpTrabajador(worker.getEmpTrabajador());

            User user = worker.getUser();
            if (user != null) {
                workerDtoResp.setUserName(user.getNombre());
                workerDtoResp.setUserCedula(user.getCedula());
            }
            createdWalletStatusDto.setWorker(workerDtoResp);
        }
        return createdWalletStatusDto;

    }

    //PUT

    public void update(WalletStatusDto walletStatusDto, int id) throws Exception {
        WalletStatus existingWalletStatus = walletStatusService.findById(id);
        if (existingWalletStatus == null) {
            throw new Exception("WalletStatus not found");
        }

        existingWalletStatus.setEstcartera(walletStatusDto.getEstcartera());
        existingWalletStatus.setFecestcartera(walletStatusDto.getFecestcartera());
        existingWalletStatus.setNotiestcartera(walletStatusDto.getNotiestcartera());

        PropertyDto propertyDto = walletStatusDto.getProperty();
        if (propertyDto != null) {
            Property property = propertyService.findById(propertyDto.getId());
            if (property != null) {
                existingWalletStatus.setProperty(property);
            }
        }

        WorkerDto workerDto = walletStatusDto.getWorker();
        if (workerDto != null) {
            Worker worker = workerService.findById(workerDto.getId());
            if (worker != null) {
                existingWalletStatus.setWorker(worker);
            }
        }

        walletStatusService.update(existingWalletStatus);
    }
    public void delete(int id) throws Exception {
        WalletStatus existingWalletStatus = walletStatusService.findById(id);
        if (existingWalletStatus == null) {
            throw new Exception("WalletStatus not found");
        }

        walletStatusService.delete(existingWalletStatus);
    }

}