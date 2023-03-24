package com.covid19.Covid19Project.tests;

import java.util.Comparator;

public class SortCountInOrder implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Integer a=(Integer)o1;
		Integer b=(Integer)o2;
		return a.compareTo(b);
	}

}
