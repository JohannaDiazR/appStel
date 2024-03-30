package com.johannad.appStel.business;

import com.johannad.appStel.dtos.PropertyDto;
import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.dtos.WorkerDto;
import com.johannad.appStel.entity.Property;
import com.johannad.appStel.entity.WalletStatus;
import com.johannad.appStel.entity.Worker;
import com.johannad.appStel.service.PropertyService;
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
    private List<WalletStatus> walletStatusList;



    public List<WalletStatusDto> findAll() throws Exception {
        this.walletStatusList=this.walletStatusService.findAll();
        List<WalletStatusDto> walletStatusDtoList = new ArrayList<>();
        this.walletStatusList.forEach(walletStatus -> {
            WalletStatusDto walletStatusDto=new WalletStatusDto();
            walletStatusDto.setId(walletStatus.getId());

            Property property = walletStatus.getProperty();
            if (property != null){
                PropertyDto propertyDto = new PropertyDto();
                propertyDto.setId(property.getId());
                propertyDto.setAndInmueble(property.getAndInmueble());
                propertyDto.setNumInmueble(property.getNumInmueble());
                walletStatusDto.setProperty(propertyDto);
            }

            Worker worker = walletStatus.getWorker();
            if (worker != null){
                WorkerDto workerDto = new WorkerDto();
                workerDto.setId(worker.getId());
                workerDto.setNomTrabajador(worker.getNomTrabajador());
                workerDto.setCcTrabajador(worker.getCcTrabajador());
                workerDto.setCelTrabajador(worker.getCelTrabajador());
                workerDto.setEmaTrabajador(worker.getEmaTrabajador());
                workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
                workerDto.setCargTrabajador(worker.getCargTrabajador());
                workerDto.setEmpTrabajador(worker.getEmpTrabajador());
                walletStatusDto.setWorker(workerDto);
            }

            walletStatusDto.setEstcartera(walletStatus.getEstcartera());
            walletStatusDto.setTaccestcartera(walletStatus.getTaccestcartera());
            walletStatusDto.setNotiestcartera(walletStatus.getNotiestcartera());
            walletStatusDtoList.add(walletStatusDto);
        });
        return walletStatusDtoList;
    }
    //POST
    public WalletStatusDto create(WalletStatusDto walletStatusDto) throws Exception {
        WalletStatus walletStatus = new WalletStatus();
        walletStatus.setEstcartera(walletStatusDto.getEstcartera());
        walletStatus.setTaccestcartera(walletStatusDto.getTaccestcartera());
        walletStatus.setNotiestcartera(walletStatusDto.getNotiestcartera());

        PropertyDto propertyDto = walletStatusDto.getProperty();
        if (propertyDto != null){
            Property property = new Property();
            property.setId(propertyDto.getId());
            property.setAndInmueble(propertyDto.getAndInmueble());
            property.setNumInmueble(propertyDto.getNumInmueble());
            walletStatus.setProperty(property);
        }
        WorkerDto workerDto = walletStatusDto.getWorker();
        if (workerDto != null) {
            Worker worker = new Worker();
            worker.setId(workerDto.getId());
            worker.setNomTrabajador(workerDto.getNomTrabajador());
            worker.setCcTrabajador(workerDto.getCcTrabajador());
            worker.setCelTrabajador(workerDto.getCelTrabajador());
            worker.setEmaTrabajador(workerDto.getEmaTrabajador());
            worker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
            worker.setCargTrabajador(workerDto.getCargTrabajador());
            worker.setEmpTrabajador(workerDto.getEmpTrabajador());
            walletStatus.setWorker(worker);
        }

        WalletStatus createdWalletStatus = walletStatusService.create(walletStatus);
        WalletStatusDto createdWalletStatusDto = new WalletStatusDto();
        createdWalletStatusDto.setId(createdWalletStatus.getId());
        createdWalletStatusDto.setEstcartera(createdWalletStatus.getEstcartera());
        createdWalletStatusDto.setTaccestcartera(createdWalletStatus.getTaccestcartera());
        createdWalletStatusDto.setNotiestcartera(createdWalletStatus.getNotiestcartera());

        Property property = createdWalletStatus.getProperty();
        if (property != null) {
            propertyDto = new PropertyDto();
            propertyDto.setId(property.getId());
            propertyDto.setAndInmueble(property.getAndInmueble());
            propertyDto.setNumInmueble(property.getNumInmueble());
        }
        Worker worker = createdWalletStatus.getWorker();
        if (worker != null) {
            workerDto = new WorkerDto();
            workerDto.setId(worker.getId());
            workerDto.setNomTrabajador(worker.getNomTrabajador());
            workerDto.setCcTrabajador(worker.getCcTrabajador());
            workerDto.setCelTrabajador(worker.getCelTrabajador());
            workerDto.setEmaTrabajador(worker.getEmaTrabajador());
            workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
            workerDto.setCargTrabajador(worker.getCargTrabajador());
            workerDto.setEmpTrabajador(worker.getEmpTrabajador());
            createdWalletStatusDto.setWorker(workerDto);
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
        existingWalletStatus.setTaccestcartera(walletStatusDto.getTaccestcartera());
        existingWalletStatus.setNotiestcartera(walletStatusDto.getNotiestcartera());

        PropertyDto propertyDto = walletStatusDto.getProperty();
        if (propertyDto != null) {
            Property existingProperty = existingWalletStatus.getProperty();
            if (existingProperty == null) {
                existingProperty = new Property();
            }
            existingProperty.setId(propertyDto.getId());
            existingProperty.setAndInmueble(propertyDto.getAndInmueble());
            existingProperty.setNumInmueble(propertyDto.getNumInmueble());

            existingWalletStatus.setProperty(existingProperty);
        }

        WorkerDto workerDto = walletStatusDto.getWorker();
        if (workerDto != null){
            Worker existingWorker = existingWalletStatus.getWorker();
            if (existingWorker == null) {
                existingWorker = new Worker();
            }
            existingWorker.setId(workerDto.getId());
            existingWorker.setNomTrabajador(workerDto.getNomTrabajador());
            existingWorker.setCcTrabajador(workerDto.getCcTrabajador());
            existingWorker.setCelTrabajador(workerDto.getCelTrabajador());
            existingWorker.setEmaTrabajador(workerDto.getEmaTrabajador());
            existingWorker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
            existingWorker.setCargTrabajador(workerDto.getCargTrabajador());
            existingWorker.setEmpTrabajador(workerDto.getEmpTrabajador());

            existingWalletStatus.setWorker(existingWorker);
        }
        walletStatusService.update(existingWalletStatus);
    }

}