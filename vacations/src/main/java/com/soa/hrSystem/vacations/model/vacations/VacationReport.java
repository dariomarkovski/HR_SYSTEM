package com.soa.hrSystem.vacations.model.vacations;

import java.time.LocalDateTime;

public class VacationReport {

    private Long employeeId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean exclusive;
    private Integer totalVacationDays;
    private Integer totalUsedVacationDays;
    private Iterable<Vacation> vacations;
    private Iterable<VacationDays> vacationDays;

    public VacationReport(Long id, LocalDateTime startDate, LocalDateTime endDate, Boolean exclusive) {
        employeeId = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.exclusive = exclusive;
	}

	public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getTotalVacationDays() {
        return totalVacationDays;
    }

    public void setTotalVacationDays(Integer totalVacationDays) {
        this.totalVacationDays = totalVacationDays;
    }

    public Integer getTotalUsedVacationDays() {
        return totalUsedVacationDays;
    }

    public void setTotalUsedVacationDays(Integer totalUsedVacationDays) {
        this.totalUsedVacationDays = totalUsedVacationDays;
    }

    public Iterable<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(Iterable<Vacation> vacations) {
        this.vacations = vacations;
    }

    public Iterable<VacationDays> getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Iterable<VacationDays> vacationDays) {
        this.vacationDays = vacationDays;
    }
}