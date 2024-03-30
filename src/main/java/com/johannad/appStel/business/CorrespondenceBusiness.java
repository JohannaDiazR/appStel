package com.johannad.appStel.business;

import com.johannad.appStel.dtos.CorrespondenceDto;
import com.johannad.appStel.dtos.WorkerDto;
import com.johannad.appStel.entity.Correspondence;
import com.johannad.appStel.entity.Worker;
import com.johannad.appStel.service.CorrespondenceService;
import com.johannad.appStel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CorrespondenceBusiness {

    @Autowired
    private CorrespondenceService correspondenceService;

    @Autowired
    private WorkerService workerService;

    private List<Correspondence> correspondenceList;

    public List<CorrespondenceDto> findAll() throws Exception {
        this.correspondenceList = this.correspondenceService.findAll();
        List<CorrespondenceDto> correspondenceDtoList = new ArrayList<>();
        this.correspondenceList.forEach(correspondence -> {
            CorrespondenceDto correspondenceDto = new CorrespondenceDto();
            correspondenceDto.setId(correspondence.getId());

            Worker worker = correspondence.getWorker();
            if (worker != null) {
                WorkerDto workerDto = new WorkerDto();
                workerDto.setId(worker.getId());
                workerDto.setNomTrabajador(worker.getNomTrabajador());
                workerDto.setCcTrabajador(worker.getCcTrabajador());
                workerDto.setCelTrabajador(worker.getCelTrabajador());
                workerDto.setEmaTrabajador(worker.getEmaTrabajador());
                workerDto.setTpcoTrabajador(worker.getTpcoTrabajador());
                workerDto.setCargTrabajador(worker.getCargTrabajador());
                workerDto.setEmpTrabajador(worker.getEmpTrabajador());
                correspondenceDto.setWorker(workerDto);
            }

            correspondenceDto.setTipoCorrespondencia(correspondence.getTipoCorrespondencia());
            correspondenceDto.setFrecCorrespondencia(correspondence.getFrecCorrespondencia());
            correspondenceDto.setEstCorrespondencia(correspondence.getEstCorrespondencia());
            correspondenceDto.setFentrCorrespondencia(correspondence.getFentrCorrespondencia());
            correspondenceDtoList.add(correspondenceDto);
        });
        return correspondenceDtoList;
    }

    // POST
    public CorrespondenceDto create(CorrespondenceDto correspondenceDto) throws Exception {
        Correspondence correspondence = new Correspondence();
        correspondence.setTipoCorrespondencia(correspondenceDto.getTipoCorrespondencia());
        correspondence.setFrecCorrespondencia(correspondenceDto.getFrecCorrespondencia());
        correspondence.setEstCorrespondencia(correspondenceDto.getEstCorrespondencia());
        correspondence.setFentrCorrespondencia(correspondenceDto.getFentrCorrespondencia());

        WorkerDto workerDto = correspondenceDto.getWorker();
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
            correspondence.setWorker(worker);
        }

        Correspondence createdCorrespondence = correspondenceService.create(correspondence);
        CorrespondenceDto createdCorrespondenceDto = new CorrespondenceDto();
        createdCorrespondenceDto.setId(createdCorrespondence.getId());
        createdCorrespondenceDto.setTipoCorrespondencia(createdCorrespondence.getTipoCorrespondencia());
        createdCorrespondenceDto.setFrecCorrespondencia(createdCorrespondence.getFrecCorrespondencia());
        createdCorrespondenceDto.setEstCorrespondencia(createdCorrespondence.getEstCorrespondencia());
        createdCorrespondenceDto.setFentrCorrespondencia(createdCorrespondence.getFentrCorrespondencia());

        Worker worker = createdCorrespondence.getWorker();
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
            createdCorrespondenceDto.setWorker(workerDto);
        }

        return createdCorrespondenceDto;
    }

    // PUT
    public void update(CorrespondenceDto correspondenceDto, int id) throws Exception {
        Correspondence existingCorrespondence = correspondenceService.findById(id);
        if (existingCorrespondence == null) {
            throw new Exception("Correspondence not found");
        }

        existingCorrespondence.setTipoCorrespondencia(correspondenceDto.getTipoCorrespondencia());
        existingCorrespondence.setFrecCorrespondencia(correspondenceDto.getFrecCorrespondencia());
        existingCorrespondence.setEstCorrespondencia(correspondenceDto.getEstCorrespondencia());
        existingCorrespondence.setFentrCorrespondencia(correspondenceDto.getFentrCorrespondencia());

        WorkerDto workerDto = correspondenceDto.getWorker();
        if (workerDto != null) {
            Worker existingWorker = existingCorrespondence.getWorker();
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

            existingCorrespondence.setWorker(existingWorker);
        }
        correspondenceService.update(existingCorrespondence);
    }

}