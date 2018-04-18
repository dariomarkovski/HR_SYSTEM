package com.soa.hrSystem.vacations.service;


import com.soa.hrSystem.vacations.model.vacations.VacationDays;

public interface IVacationDaysService {

	void delete(Long vacationDaysId);

	VacationDays save(Long id, VacationDays vacationDays);

	Integer getVacationDaysForEmployee(Long id, String startDate, String endDate, Boolean exclusive);

}