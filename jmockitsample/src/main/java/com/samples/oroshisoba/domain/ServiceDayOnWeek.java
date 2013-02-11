package com.samples.oroshisoba.domain;

import java.util.HashSet;
import java.util.Set;


public class ServiceDayOnWeek {

	private Set<Integer> days = new HashSet<Integer>();

	public Integer[] getDays() {
		Integer[] result = new Integer[days.size()];
		return days.toArray(result);
	}

	public void addServiceDay(int day) {
		days.add(day);
	}
}
