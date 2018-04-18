package com.soa.hrSystem.archive.web;

import com.soa.hrSystem.archive.model.archive.Document;
import com.soa.hrSystem.archive.model.archive.exceptions.DocumentNotFoundException;
import com.soa.hrSystem.archive.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/documents")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    Document save(@ModelAttribute Document document, @RequestParam("date") String date) {
        return this.documentService.save(document,date);
    }

    @GetMapping(value = "/id/{id}")
    Optional<Document> findOne(@PathVariable("id") Long id) throws DocumentNotFoundException {
        return this.documentService.findOne(id);
    }

    @GetMapping(value = "/label/{label}")
    Iterable<Document> findByLabel(@PathVariable("label") String label) {
        return documentService.findByLabel(label);
    }

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable("id") Long id) {
        this.documentService.delete(id);
    }

    @GetMapping
    Iterable<Document> findAll() {
        return documentService.findAll();
    }

}
