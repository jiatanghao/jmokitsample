package com.samples.oroshisoba.parser;

import static org.junit.Assert.*;

import javax.swing.text.html.HTMLEditorKit.Parser;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

import com.samples.oroshisoba.domain.Employee;

public class MainParserTest {

	private MainParser mainParser = new MainParser();

	@Mocked
	ParseHelper parseHelper;

	@Test
	public void testParse() {
		final String line = "abcdefghijkl";
		
		new Expectations() {
			{
				ParseHelper.parse(line);
				Employee employee = new Employee();
				employee.setName("name1");
				result = employee;
				Employee employee2 = new Employee();
				employee2.setName("name2");
				result = employee2;
				Employee employee3 = new Employee();
				employee3.setName("name3");
				result = employee3;
				times = 3;
			}
		};

		Object result = mainParser.parse(line);
		assertNotNull(result);
		assertEquals(Employee.class, result.getClass());
		Employee actual = (Employee) result;
		assertEquals("name1", actual.getName());

		Object result2 = mainParser.parse(line);
		Employee actual2 = (Employee) result2;
		assertEquals("name2", actual2.getName());

		Object result3 = mainParser.parse(line);
		Employee actual3 = (Employee) result3;
		assertEquals("name3", actual3.getName());

	}

}
