package com.soa.hrSystem.vacations.service;


import com.soa.hrSystem.vacations.model.vacations.Vacation;
import com.soa.hrSystem.vacations.model.vacations.VacationReport;

public interface IVacationService {
    
    Iterable<Vacation> getAllVacationsForEmployee(Long id);

    Iterable<Vacation> getAllVacationsForEmployee(Long id, String date);

    Iterable<Vacation> getVacationsForEmployee(Long id, String startDate, String endDate, Boolean exclusive);

	Vacation save(Long employeeId, Vacation vacation);

	void delete(Long vacationId);

	VacationReport getReportForEmployee(Long id, String startDate, String endDate, Boolean exclusive);

}