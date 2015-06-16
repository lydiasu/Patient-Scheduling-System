package edu.miami.cis324.hw4.ysu;

import java.util.*;

public class SchedulerData {
	
	
	
	private ArrayList<Patient> p = new ArrayList<Patient>();
	
	private ArrayList<Doctor> d = new ArrayList<Doctor>();
	
	private ArrayList<Visit<Integer,Integer>> v = new ArrayList<Visit<Integer,Integer>>();
	
	public SchedulerData (ArrayList<Patient> pp, ArrayList<Doctor> dd, ArrayList<Visit<Integer,Integer>> vv)
	{
		p = pp;
		
		d = dd;
		
		v = vv;
	}
	
	public ArrayList<Patient> getPatientList()
	{
		return p;
	}
	
	public ArrayList<Doctor> getDoctorList(){
		
		return d;
	}
	
	public ArrayList<Visit<Integer,Integer>> getVisitList (){
		
		return v;
	}
	
	public void addPatient(Patient p1){
		
		p.add(p1);
	}
	
	public void addDoctor(Doctor d1){
		d.add(d1);
	}
	public void addVisit(Visit<Integer,Integer> v1){
		
		v.add(v1);
	}
	

}
