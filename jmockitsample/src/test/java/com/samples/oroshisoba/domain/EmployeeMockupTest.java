package com.samples.oroshisoba.domain;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;

public class EmployeeMockupTest {

	@SuppressWarnings("unused")
	@Test
	public void WorkAndGetTest() {

		new MockUp<ServiceDayOnWeek>() {

			@Mock(invocations = 1)
			public void addServiceDay(int day) {
				Calendar calendar = Calendar.getInstance();
				assertEquals(calendar.get(Calendar.DAY_OF_WEEK), day);
			}
			
			@Mock(invocations = 1)
			public Integer[] getDays() {
				return new Integer[] { Calendar.WEDNESDAY, Calendar.THURSDAY };
			}
		};

		Employee employee = new Employee();
		employee.work();

		Integer[] days = employee.getServiceDayOnThisWeek();
		assertEquals(2, days.length);
		assertEquals(Calendar.WEDNESDAY, (int) days[0]); 
		assertEquals(Calendar.THURSDAY, (int) days[1]); 
	}
}
