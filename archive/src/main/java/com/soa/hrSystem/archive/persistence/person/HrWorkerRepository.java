package com.soa.hrSystem.archive.persistence.person;

import com.soa.hrSystem.archive.model.archive.HrWorker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrWorkerRepository extends CrudRepository<HrWorker, Long> {
}
