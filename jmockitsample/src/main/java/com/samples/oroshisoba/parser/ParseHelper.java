package com.samples.oroshisoba.parser;

import com.samples.oroshisoba.domain.Employee;

public class ParseHelper {

	public static Object parse(String line) {
		
		if (line == null || line.length() < 10) {
			throw new IllegalArgumentException();
		}
		
		Employee employee = new Employee();
		String name = line.substring(3, 8);
		employee.setName(name);

		return employee;
	}
}
