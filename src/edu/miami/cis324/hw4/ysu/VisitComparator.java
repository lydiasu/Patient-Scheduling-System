package edu.miami.cis324.hw4.ysu;

import java.util.*;

public class VisitComparator<V,T> implements Comparator<Visit<V,T>> {
	
	@Override
	public int compare(Visit<V, T> o1, Visit<V, T> o2) {
		
		Date d1 =o1.getDateOfVisit();
		
		Date d2 = o2.getDateOfVisit();
		
		return d1.compareTo(d2);
		
	}


}
