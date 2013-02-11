package com.samples.oroshisoba.domain;

import java.math.BigDecimal;
import java.util.Calendar;


public class Salary {

	public static final BigDecimal BASE_SALARY = new BigDecimal("25000");
	public static final BigDecimal HOLIDAY_RATE = new BigDecimal("1.5");

	/**
	 * WeekDay: 25000
	 * Holiday: 25000 * 1.5
	 * 
	 * @param employee
	 * @return
	 */
	public BigDecimal calculate(Employee employee) {
		Integer[] days = employee.getServiceDayOnThisWeek();

		BigDecimal salary = BigDecimal.ZERO;

		for (Integer day : days) {
			switch (day) {
			case Calendar.SATURDAY:
			case Calendar.SUNDAY:
				BigDecimal temp = BASE_SALARY.multiply(HOLIDAY_RATE);
				salary = salary.add(temp);
				break;
			default:
				salary = salary.add(BASE_SALARY);
				break;
			}
		}
		
		return salary;
	}
}
