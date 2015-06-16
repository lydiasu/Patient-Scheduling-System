package edu.miami.cis324.hw4.ysu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;


public class SchedulerReadTest {
	

	private final static String INPUT_FILE = "/Users/suyuqing/Desktop/Final Project/resources/schedulerData.xml";
	private final static String OUTPUT_FILE = "/Users/suyuqing/Desktop/Final Project/resources/schedulerDataOut.xml";
	
	
	public static void main(String [] args)throws XMLStreamException, IOException{
		
		SchedulerData sd = SchedulerXMLReaderUtils.readSchedulingXML(INPUT_FILE);
	
		

		Map<Integer, Patient> patientIdMap = new HashMap<Integer, Patient>();
		 
		 
		for (int i = 0; i < sd.getPatientList().size(); i++)
		 {	
			
			 patientIdMap.put(sd.getPatientList().get(i).getPatientID(), sd.getPatientList().get(i));
		  	
		 }
		
		/*for(Integer key:patientIdMap.keySet() )
		 {
			 System.out.println(key + " " + patientIdMap.get(key).getPatientFname());
		 }
		 */
		 Map<Integer, Doctor> doctorIdMap = new HashMap<Integer, Doctor>(); 
		 
		 for(int j = 0; j < sd.getDoctorList().size(); j++)
		 {
			 doctorIdMap.put(sd.getDoctorList().get(j).getDoctorID(), sd.getDoctorList().get(j));
		 }
		 
		 
		 /*for(Integer key:doctorIdMap.keySet() )
		 {
			 System.out.println(key + " " + doctorIdMap.get(key).getDoctorFname());
		 }*/
		 
		 
		
		 Collections.sort(sd.getVisitList(),new VisitComparator<Integer,Integer>());
		
	
		 
		
		 
		 for(int k = 0; k < sd.getVisitList().size(); k++)
		 {
			 Date today = new Date();
			 
			 if(sd.getVisitList().get(k).getDateOfVisit().compareTo(today) > 0)
			 {
				 System.out.println("Visit Date: " + "\t\t" + XMLReaderUtils.DateToString("MMMM dd, yyyy", sd.getVisitList().get(k).getDateOfVisit()));
			 
			 
				 for(Integer key: doctorIdMap.keySet())
				 {	
					 if(key.equals(sd.getVisitList().get(k).getHost()))
					 {
						 System.out.println("Doctor:" + "\t\t\t" + doctorIdMap.get(key).getDoctorFname() + " " + doctorIdMap.get(key).getDoctorLname());
					
						 System.out.println("Specialty: " + "\t\t" + doctorIdMap.get(key).getSpecialty());
					 }
					 
					 
				 }
				 
				 long days = XMLReaderUtils.differenceBetweenDates(today, sd.getVisitList().get(k).getDateOfVisit());
				 
				 System.out.println("Days Until Visit: " + "\t" + days);
				 
				 
				 for(Integer key1: patientIdMap.keySet())
				 {
					 if(key1.equals(sd.getVisitList().get(k).getVisitor()))
					 {
						 System.out.println("Patient: " );
						 
						 System.out.println("\tFirst Name: "+"\t"+ patientIdMap.get(key1).getPatientFname());
						 
						 System.out.println("\tLast Name: "+ "\t"+patientIdMap.get(key1).getPatientLname());
						 
						 System.out.println("\tEmail: " + "\t\t" + patientIdMap.get(key1).getEmail());
						 
						 System.out.println("\tSSN" + "\t\t" + patientIdMap.get(key1).getSSN());
						 
						 int age = XMLReaderUtils.calculateAge(patientIdMap.get(key1).getDob());
						 
						 System.out.println("\tAge: " + "\t\t" + age);
						 
					 }
				 }
				 
				 
			
				 
			 }
			 
			 	
			 System.out.println("\n");
		 }
		 
		 
		 
		 ArrayList<Visit<String, String>> visitList = new  ArrayList<Visit<String, String>>();
		 
		 for(Visit<Integer, Integer> vl: sd.getVisitList())
		 {
			 
			 String pN = null;
			 
			 String dN = null;
			 
			
			 
			 for(Integer key:patientIdMap.keySet())
			 {
				 
				
				 if(vl.getVisitor().equals(patientIdMap.get(key).getPatientID()))
				 {
					 pN = patientIdMap.get(key).getPatientName();
				 }
			 }
			 
			 for(Integer key:doctorIdMap.keySet())
			 {
				 if(vl.getHost().equals(doctorIdMap.get(key).getDoctorID()))
				 {
					 dN = doctorIdMap.get(key).getDoctorName();
				 }
			 }
			 
			 Visit<String,String> vs = new Visit<String,String>(pN, dN, vl.getDateOfVisit());
			 
			 visitList.add(vs);
		 }
		 
		 
		 SchedulerWriterUtils.writeSchedulerData(OUTPUT_FILE, sd.getPatientList(), sd.getDoctorList(), visitList);


	}

}
