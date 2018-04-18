package com.soa.hrSystem.vacations.model.archive;


import com.soa.hrSystem.vacations.model.Person;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Document")
public class Document {
    //id na dokumentot
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String label;

    @Column(nullable = true)
    private String description;

    private LocalDateTime dateOfCreation;

    @Column(nullable = true)
    private LocalDate dateOfExpiration;

    @Column(nullable = true)
    private LocalDateTime notificationDate;

    private String context;

    @JoinColumn(nullable = false)
    @ManyToOne
    private HrWorker signaturesFromHR;

    @JoinColumn(nullable = true)
    @ManyToOne
    private Person signatures;

    public Document() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDate getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(LocalDate dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public LocalDateTime getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(LocalDateTime notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public HrWorker getSignaturesFromHR() {
        return signaturesFromHR;
    }

    public Person getSignatures() {
        return signatures;
    }

    public void setSignaturesFromHR(HrWorker signaturesFromHR) {
        this.signaturesFromHR = signaturesFromHR;
    }

    public void setSignatures(Person signatures) {
        this.signatures = signatures;
    }

    public Document(String label, String description, LocalDateTime dateOfCreation, LocalDate dateOfExpiration, LocalDateTime notificationDate, String context) {
        this.label = label;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.dateOfExpiration = dateOfExpiration;
        this.notificationDate = notificationDate;
        this.context = context;
    }

}