package com.samples.oroshisoba.domain;

import java.util.Calendar;
import java.util.Date;

public class Employee {

	private String employeeId;
	
	private String name;
	
	private Integer hourInDay;

	private Address address;
	
	private ServiceDayOnWeek serviceDayOnWeek = new ServiceDayOnWeek();
	
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHourInDay() {
		return hourInDay;
	}

	public void setHourInDay(Integer hourInDay) {
		this.hourInDay = hourInDay;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ServiceDayOnWeek getServiceDayOnWeek() {
		return serviceDayOnWeek;
	}

	public void setServiceDayOnWeek(ServiceDayOnWeek serviceDayOnWeek) {
		this.serviceDayOnWeek = serviceDayOnWeek;
	}

	public void work(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);		
		serviceDayOnWeek.addServiceDay(calendar.get(Calendar.DAY_OF_WEEK));
	}

	public void work() {
		Calendar calendar = Calendar.getInstance();
		serviceDayOnWeek.addServiceDay(calendar.get(Calendar.DAY_OF_WEEK));
	}
	
	public Integer[] getServiceDayOnThisWeek() {
		return this.serviceDayOnWeek.getDays();
	}
}
