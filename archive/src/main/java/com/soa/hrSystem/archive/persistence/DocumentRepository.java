package com.soa.hrSystem.archive.persistence;

import com.soa.hrSystem.archive.model.archive.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {

    Iterable<Document> findAllByLabel(String label);

}
