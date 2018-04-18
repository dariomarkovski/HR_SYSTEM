package com.soa.hrSystem.archive.service.Implementation;

import com.soa.hrSystem.archive.model.archive.HrWorker;
import com.soa.hrSystem.archive.model.archive.exceptions.HrWorkerNotFoundException;
import com.soa.hrSystem.archive.persistence.person.HrWorkerRepository;
import com.soa.hrSystem.archive.service.HrWorkerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HrWorkerServiceImplementation implements HrWorkerService {
    private final HrWorkerRepository hrWorkerRepository;

    public HrWorkerServiceImplementation(HrWorkerRepository hrWorkerRepository) {
        this.hrWorkerRepository = hrWorkerRepository;
    }

    @Override
    public HrWorker save(HrWorker hrWorker) {
        return this.hrWorkerRepository.save(hrWorker);
    }

    @Override
    public HrWorker getById(Long id) throws HrWorkerNotFoundException {
        Optional<HrWorker> hrWorker = hrWorkerRepository.findById(id);
        return hrWorker.orElseThrow(() -> new HrWorkerNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        this.hrWorkerRepository.deleteById(id);
    }

    @Override
    public Iterable<HrWorker> getAllHrWorkers() {
        return this.hrWorkerRepository.findAll();
    }
}
