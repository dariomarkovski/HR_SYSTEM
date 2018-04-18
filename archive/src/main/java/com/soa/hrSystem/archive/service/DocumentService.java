package com.soa.hrSystem.archive.service;

import com.soa.hrSystem.archive.model.archive.Document;
import com.soa.hrSystem.archive.model.archive.exceptions.DocumentNotFoundException;

import java.util.Optional;

public interface DocumentService {
    Document save(Document document, String date);

    Optional<Document> findOne(Long id) throws DocumentNotFoundException;

    void delete(Long id);

    Iterable<Document> findByLabel(String label);

    Iterable<Document> findAll();
}
