package com.johannad.appStel.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.johannad.appStel.dtos.AdminDocsDto;
import com.johannad.appStel.dtos.RoleDto;
import com.johannad.appStel.dtos.WorkerDto;
import com.johannad.appStel.entity.AdminDocs;
import com.johannad.appStel.entity.Role;
import com.johannad.appStel.entity.Worker;
import com.johannad.appStel.service.AdminDocsService;
import com.johannad.appStel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminDocsBusiness {

    @Autowired
    private AdminDocsService adminDocsService;

    @Autowired
    private WorkerService workerService;

    private List<AdminDocs> adminDocsList;



    public List<AdminDocsDto> findAll() throws Exception {
        this.adminDocsList = this.adminDocsService.findAll();
        List<AdminDocsDto> adminDocsDtoList = new ArrayList<>();
        this.adminDocsList.forEach(adminDocs -> {
            AdminDocsDto adminDocsDto = new AdminDocsDto();
            adminDocsDto.setId(adminDocs.getId());

            Worker worker = adminDocs.getWorker();
            if (worker != null) {
                WorkerDto workerDto = new WorkerDto();
                workerDto.setId(worker.getId());
                workerDto.setNomTrabajador(worker.getNomTrabajador());
                workerDto.setCcTrabajador(worker.getCcTrabajador());
                workerDto.setCelTrabajador(worker.getCelTrabajador());
                workerDto.setEmaTrabajador(worker.getEmaTrabajador());
                workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
                workerDto.setConTrabajador(worker.getConTrabajador());
                workerDto.setCargTrabajador(worker.getCargTrabajador());
                workerDto.setEmpTrabajador(worker.getEmpTrabajador());
                adminDocsDto.setWorker(workerDto);
            }

            adminDocsDto.setClassDocsAdmin(adminDocs.getClassDocsAdmin());
            adminDocsDto.setPetiDocsAdmin(adminDocs.getPetiDocsAdmin());
            adminDocsDtoList.add(adminDocsDto);

        });
        return adminDocsDtoList;
    }

    public AdminDocsDto create(AdminDocsDto adminDocsDto) throws Exception {
        AdminDocs adminDocs = new AdminDocs();
        adminDocs.setClassDocsAdmin(adminDocsDto.getClassDocsAdmin());
        adminDocs.setPetiDocsAdmin(adminDocsDto.getPetiDocsAdmin());

        WorkerDto workerDto = adminDocsDto.getWorker();
        if (workerDto != null) {
            Worker worker = new Worker();
            worker.setId(workerDto.getId());
            worker.setNomTrabajador(workerDto.getNomTrabajador());
            worker.setCcTrabajador(workerDto.getCcTrabajador());
            worker.setCelTrabajador(workerDto.getCelTrabajador());
            worker.setEmaTrabajador(workerDto.getEmaTrabajador());
            worker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
            worker.setConTrabajador(workerDto.getConTrabajador());
            worker.setCargTrabajador(workerDto.getCargTrabajador());
            worker.setEmpTrabajador(workerDto.getEmpTrabajador());
            adminDocs.setWorker(worker);
        }

        AdminDocs createdAdminDocs = adminDocsService.create(adminDocs);
        AdminDocsDto createdAdminDocsDto = new AdminDocsDto();
        createdAdminDocsDto.setId(createdAdminDocs.getId());
        createdAdminDocsDto.setClassDocsAdmin(createdAdminDocs.getClassDocsAdmin());
        createdAdminDocsDto.setPetiDocsAdmin(createdAdminDocs.getPetiDocsAdmin());

        Worker worker = createdAdminDocs.getWorker();
        if (worker != null) {
            workerDto = new WorkerDto();
            workerDto.setId(worker.getId());
            workerDto.setNomTrabajador(worker.getNomTrabajador());
            workerDto.setCcTrabajador(worker.getCcTrabajador());
            workerDto.setCelTrabajador(worker.getCelTrabajador());
            workerDto.setEmaTrabajador(worker.getEmaTrabajador());
            workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
            workerDto.setConTrabajador(worker.getConTrabajador());
            workerDto.setCargTrabajador(worker.getCargTrabajador());
            workerDto.setEmpTrabajador(worker.getEmpTrabajador());
            createdAdminDocsDto.setWorker(workerDto);
        }

        return createdAdminDocsDto;
    }

    public void update(AdminDocsDto adminDocsDto, int id) throws Exception {
        AdminDocs existingAdminDocs = adminDocsService.findById(id);
        if (existingAdminDocs == null) {
            throw new Exception("AdminDocs not found");
        }

        existingAdminDocs.setClassDocsAdmin(adminDocsDto.getClassDocsAdmin());
        existingAdminDocs.setPetiDocsAdmin(adminDocsDto.getPetiDocsAdmin());

        WorkerDto workerDto = adminDocsDto.getWorker();
        if (workerDto != null) {
            Worker existingWorker = existingAdminDocs.getWorker();
            if (existingWorker == null) {
                existingWorker = new Worker();
            }

            existingWorker.setId(workerDto.getId());
            existingWorker.setNomTrabajador(workerDto.getNomTrabajador());
            existingWorker.setCcTrabajador(workerDto.getCcTrabajador());
            existingWorker.setCelTrabajador(workerDto.getCelTrabajador());
            existingWorker.setEmaTrabajador(workerDto.getEmaTrabajador());
            existingWorker.setTpcoTrabajador(workerDto.getTpcoTrabajador());
            existingWorker.setConTrabajador(workerDto.getConTrabajador());
            existingWorker.setCargTrabajador(workerDto.getCargTrabajador());
            existingWorker.setEmpTrabajador(workerDto.getEmpTrabajador());

            existingAdminDocs.setWorker(existingWorker);
        }

        adminDocsService.update(existingAdminDocs);
    }

}