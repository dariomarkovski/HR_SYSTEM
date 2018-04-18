package com.soa.hrSystem.archive.service.Implementation;

import com.soa.hrSystem.archive.model.Person;
import com.soa.hrSystem.archive.model.archive.Document;
import com.soa.hrSystem.archive.model.archive.HrWorker;
import com.soa.hrSystem.archive.model.archive.exceptions.DocumentNotFoundException;
import com.soa.hrSystem.archive.persistence.DocumentRepository;
import com.soa.hrSystem.archive.persistence.person.HrWorkerRepository;
import com.soa.hrSystem.archive.persistence.person.PersonRepository;
import com.soa.hrSystem.archive.service.DocumentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final HrWorkerRepository hrWorkerRepository;
    private final PersonRepository personRepository;
    public static Long SEQUENCE = 1L;

    public DocumentServiceImpl(DocumentRepository documentRepository, HrWorkerRepository hrWorkerRepository, PersonRepository personRepository) {
        this.documentRepository = documentRepository;
        this.hrWorkerRepository = hrWorkerRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Document save(Document document, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        if (document.getSignaturesFromHR() == null) {
            HrWorker hrWorker = new HrWorker();
            Long num = SEQUENCE;
            num++;
            hrWorker.setEMBG(String.valueOf(num));
            hrWorker.setFirstName("RandomName" + String.valueOf(num));
            hrWorker.setLastName("RandomLastName" + String.valueOf(num));
            hrWorkerRepository.save(hrWorker);
            document.setSignaturesFromHR(hrWorker);
        }
        if (document.getSignatures() == null) {
            Person person = new Person();
            Long num = SEQUENCE;
            num++;
            person.setEMBG(String.valueOf(num));
            person.setFirstName("RandomName" + String.valueOf(num));
            person.setLastName("RandomLastName" + String.valueOf(num));
            personRepository.save(person);
            document.setSignatures(person);
        }
        SEQUENCE++;
        LocalDate ld = LocalDate.parse(date, formatter);
        document.setDateOfCreation(LocalDateTime.now());
        document.setDateOfExpiration(ld);
        return this.documentRepository.save(document);
    }

    @Override
    public Optional<Document> findOne(Long id) throws DocumentNotFoundException {
        Optional<Document> document = this.documentRepository.findById(id);
        if (document.isPresent()) {
            return document;
        } else {
            throw new DocumentNotFoundException(id);
        }
    }

    @Override
    public void delete(Long id) {
        this.documentRepository.deleteById(id);
    }

    @Override
    public Iterable<Document> findByLabel(String label) {
        return this.documentRepository.findAllByLabel(label);
    }

    @Override
    public Iterable<Document> findAll() {
        return this.documentRepository.findAll();
    }

}
