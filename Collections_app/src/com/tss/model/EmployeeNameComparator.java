package com.tss.model;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<EmployeeModel> {

	@Override
	public int compare(EmployeeModel o1, EmployeeModel o2) {
		return o1.getName().compareTo(o2.getName());
	}
		
}
