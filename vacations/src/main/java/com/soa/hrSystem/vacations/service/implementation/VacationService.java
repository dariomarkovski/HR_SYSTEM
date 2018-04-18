package com.soa.hrSystem.vacations.service.implementation;


import com.soa.hrSystem.vacations.model.Employee;
import com.soa.hrSystem.vacations.model.vacations.Vacation;
import com.soa.hrSystem.vacations.model.vacations.VacationDays;
import com.soa.hrSystem.vacations.model.vacations.VacationReport;
import com.soa.hrSystem.vacations.persistence.VacationDaysRepository;
import com.soa.hrSystem.vacations.persistence.VacationRepository;
import com.soa.hrSystem.vacations.service.IVacationService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.StreamSupport;

@Service
public class VacationService implements IVacationService {

    @PersistenceContext
    private EntityManager entityManager;

    private VacationRepository vacationRepository;
    private VacationDaysRepository vacationDaysRepository;

    public VacationService(VacationRepository vacationRepository, VacationDaysRepository vacationDaysRepository) {
        this.vacationRepository = vacationRepository;
        this.vacationDaysRepository = vacationDaysRepository;
    }

    @Override
    public Iterable<Vacation> getVacationsForEmployee(Long id, String startDate, String endDate, Boolean exclusive) {
        if (startDate == null && endDate == null) {
            return getAllVacationsForEmployee(id);
        } else if (startDate != null && endDate == null) {
            return getAllVacationsForEmployee(id, startDate);
        } else if (startDate == null && endDate != null) {
            return getAllVacationsForEmployee(id, endDate);
        } else {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
            LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);

            if (exclusive) {
                return vacationRepository.findVacationsForEmployeeExclusive(id, startDateTime, endDateTime);
            } else {
                return vacationRepository.findVacationsForEmployee(id, startDateTime, endDateTime);
            }
        }
    }

    @Override
    public Iterable<Vacation> getAllVacationsForEmployee(Long id) {
        return vacationRepository.findVacationsForEmployee(id);
    }

    @Override
    public Iterable<Vacation> getAllVacationsForEmployee(Long id, String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        return vacationRepository.findVacationsForEmployee(id, dateTime);
    }

    @Override
    public Vacation save(Long employeeId, Vacation vacation) {

        Employee employee = entityManager.getReference(Employee.class, employeeId);

        vacation.setEmployee(employee);

        return vacationRepository.save(vacation);
    }

    @Override
    public void delete(Long vacationId) {
        vacationRepository.deleteById(vacationId);
    }

    @Override
    public VacationReport getReportForEmployee(Long id, String startDate, String endDate, Boolean exclusive) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);

        VacationReport vacationReport = new VacationReport(id, startDateTime, endDateTime, exclusive);

        Iterable<Vacation> vacations;
        Iterable<VacationDays> vacationDays;

        if (exclusive) {
            vacations = vacationRepository.findVacationsForEmployeeExclusive(id, startDateTime, endDateTime);
            vacationDays = vacationDaysRepository.findVacationDaysForEmployeeExclusive(id, startDateTime, endDateTime);
        } else {
            vacations = vacationRepository.findVacationsForEmployee(id, startDateTime, endDateTime);
            vacationDays = vacationDaysRepository.findVacationDaysForEmployee(id, startDateTime, endDateTime);
        }

        int totalVacationDays = StreamSupport.stream(vacations.spliterator(), false).mapToInt(Vacation::getDuration).sum();
        int totalUsedVacationDays = StreamSupport.stream(vacationDays.spliterator(), false).mapToInt(VacationDays::getAmount).sum();

        vacationReport.setVacations(vacations);
        vacationReport.setVacationDays(vacationDays);

        vacationReport.setTotalVacationDays(totalVacationDays);
        vacationReport.setTotalUsedVacationDays(totalUsedVacationDays);

        return vacationReport;
    }

}