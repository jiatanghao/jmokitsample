package com.samples.oroshisoba.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;

public class SalaryMockTest {

	private Salary salary;

	@Mocked
	Employee employee;

	@Before
	public void setUp() {
		salary = new Salary();
	}

	@Test
	public void testCalculate() {
		
		new Expectations() {{
			employee.getServiceDayOnThisWeek();
			result = new Integer[] { Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY };
			result = new Integer[] { Calendar.MONDAY, Calendar.TUESDAY };
			result = new Integer[] { Calendar.SATURDAY, Calendar.SUNDAY };
		}};

		BigDecimal actual1 = salary.calculate(employee);
		BigDecimal expected1 = Salary.BASE_SALARY.multiply(new BigDecimal("5"));
		assertEquals(expected1, actual1);

		BigDecimal actual2 = salary.calculate(employee);
		BigDecimal expected2 = Salary.BASE_SALARY.multiply(new BigDecimal("2"));
		assertEquals(expected2, actual2);

		BigDecimal actual3 = salary.calculate(employee);
		BigDecimal expected3 = Salary.BASE_SALARY.multiply(new BigDecimal("2")).multiply(Salary.HOLIDAY_RATE);
		assertEquals(expected3, actual3);

	}

}
