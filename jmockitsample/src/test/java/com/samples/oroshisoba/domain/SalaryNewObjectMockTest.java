package com.samples.oroshisoba.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

public class SalaryNewObjectMockTest {

	private Salary salaryCheck = new Salary();

	@Mocked("getDays")
	final ServiceDayOnWeek serviceDayOnWeek = new ServiceDayOnWeek();

	@SuppressWarnings("unused")
	@Test
	public void testCalculateWithMock() {

		new Expectations() {
			{
				serviceDayOnWeek.getDays();
				result = new Delegate<ServiceDayOnWeek>() {
					Integer[] getDays() {
						return new Integer[]  { Calendar.THURSDAY, Calendar.WEDNESDAY };
					}
				};
			}
		};
		
		Employee employee = new Employee();
		BigDecimal salary = salaryCheck.calculate(employee);
		assertEquals(new BigDecimal("50000"), salary);
	}
	
}
