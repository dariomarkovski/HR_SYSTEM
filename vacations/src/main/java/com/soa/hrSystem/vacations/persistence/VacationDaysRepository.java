package com.soa.hrSystem.vacations.persistence;

import com.soa.hrSystem.vacations.model.vacations.VacationDays;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface VacationDaysRepository extends CrudRepository<VacationDays, Long> {

    @Query("SELECT SUM(vd.amount) FROM VacationDays vd WHERE employee.id = :id AND "
            + "validFrom < :startDate AND validTo > :endDate")
    int sumVacationDaysForEmployeeExclusive(Long id, LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT SUM(vd.amount) FROM VacationDays vd WHERE employee.id = :id AND "
            + "((:startDate > validFrom AND :startDate < validTo) OR (:endDate > validFrom AND :endDate < validTo))")
    int sumVacationDaysForEmployee(Long id, LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT vd FROM VacationDays vd WHERE employee.id = :id AND " + "validFrom < :startDate AND validTo > :endDate")
    Iterable<VacationDays> findVacationDaysForEmployeeExclusive(Long id, LocalDateTime startDate,
                                                                LocalDateTime endDate);

    @Query("SELECT vd FROM VacationDays vd WHERE employee.id = :id AND "
            + "((:startDate > validFrom AND :startDate < validTo) OR (:endDate > validFrom AND :endDate < validTo))")
    Iterable<VacationDays> findVacationDaysForEmployee(Long id, LocalDateTime startDate, LocalDateTime endDate);

}
