package com.soa.hrSystem.vacations.service.implementation;

import com.soa.hrSystem.vacations.model.Employee;
import com.soa.hrSystem.vacations.model.vacations.VacationDays;
import com.soa.hrSystem.vacations.persistence.VacationDaysRepository;
import com.soa.hrSystem.vacations.persistence.VacationRepository;
import com.soa.hrSystem.vacations.service.IVacationDaysService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class VacationDaysService implements IVacationDaysService {

    @PersistenceContext
    private EntityManager entityManager;

    private VacationDaysRepository vacationDaysRepository;
    private VacationRepository vacationRepository;

    public VacationDaysService(VacationDaysRepository vacationDaysRepository, VacationRepository vacationRepository) {
        this.vacationDaysRepository = vacationDaysRepository;
        this.vacationRepository = vacationRepository;
    }

    @Override
    public Integer getVacationDaysForEmployee(Long id, String startDate, String endDate, Boolean exclusive) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);

        int vacationDays = 0;

        if (exclusive) {
            vacationDays = vacationDaysRepository.sumVacationDaysForEmployeeExclusive(id, startDateTime, endDateTime)
                    - vacationRepository.sumVacationDurationForEmployeeExclusive(id, startDateTime, endDateTime);
        } else {
            vacationDays = vacationDaysRepository.sumVacationDaysForEmployee(id, startDateTime, endDateTime)
                    - vacationRepository.sumVacationDurationForEmployee(id, startDateTime, endDateTime);
        }

        return vacationDays;
    }

	@Override
	public VacationDays save(Long id, VacationDays vacationDays) {

        Employee employee = entityManager.getReference(Employee.class, id);

        vacationDays.setEmployee(employee);
        
        return vacationDaysRepository.save(vacationDays);
	}

	@Override
	public void delete(Long vacationDaysId) {
        vacationDaysRepository.deleteById(vacationDaysId);
	}

}