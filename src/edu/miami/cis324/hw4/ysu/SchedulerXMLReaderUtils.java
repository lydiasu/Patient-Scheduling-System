package edu.miami.cis324.hw4.ysu;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class SchedulerXMLReaderUtils extends ReadWriteUtils
{
	
	
private final static String DOB_FORMAT = "MM/dd/yyyy";
	
	public static Patient readPatient(XMLEventReader eventReader) throws XMLStreamException {
		XMLEvent firstEvent = eventReader.nextEvent(); 
		if (!firstEvent.isStartElement()) {
			throw new IllegalStateException("Attempting to read a patient but not a start element: found event of type " + firstEvent.getEventType());
		}
		else if (!firstEvent.asStartElement().getName().getLocalPart().equals(PATIENT)) {
			throw new IllegalStateException("Attempting to read a patient at the wrong start element: found " + firstEvent.asStartElement().getName());
		}
		int id = 0;
		String ssn = null;
		@SuppressWarnings("unchecked") 
		Iterator<Attribute> attributes = firstEvent.asStartElement().getAttributes();
		while (attributes.hasNext()) {
			Attribute attribute = attributes.next();
			if (attribute.getName().getLocalPart().equals(ID)) {
				id = Integer.valueOf(attribute.getValue()); 
			}
			else if (attribute.getName().getLocalPart().equals(SSN)) {
				ssn = attribute.getValue();
			}
			else {
				System.err.println("Found unknown attribute, ignoring; found: " + attribute.getName());
			}
		}
		Patient patient = null;
		String name = null;
		String email = null;
		
		String dob1 = null;
		Date dob = null;
		
		boolean finished = false;
		while (!finished) {
			XMLEvent event = eventReader.peek(); 
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				
				 if (startElement.getName().getLocalPart().equals(EMAIL)) {
					email = XMLReaderUtils.readCharacters(eventReader, EMAIL);
				}
				 else if (startElement.getName().getLocalPart().equals(DOB)) {
						dob1 = XMLReaderUtils.readCharacters(eventReader, DOB);
						
						dob = XMLReaderUtils.formatter(dob1, DOB_FORMAT);
						
					}
				else if (startElement.getName().getLocalPart().equals(NAME)) {
					name = XMLReaderUtils.readCharacters(eventReader, NAME);
				}
				
				
				else {
					System.err.println("Unrecognized element, ignoring: " + startElement.getName());
					event = eventReader.nextEvent(); 
				}
			}
			
			else if (event.isEndElement()) {
				event = eventReader.nextEvent(); 
				EndElement endElement = event.asEndElement();
				
				if (endElement.getName().getLocalPart().equals(PATIENT)) {
					
					patient = new Patient(id, name,ssn, dob, email);
					finished = true;
				}
			}
			else {
				
				event = eventReader.nextEvent(); 
			}
		}
		return patient;
	}


	

	
	/*public static ArrayList<Patient> readPatients(String xmlFile) throws XMLStreamException, IOException {
		
		ArrayList<Patient> patientList = new ArrayList<>();
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		
		Path xmlFilePath = Paths.get(xmlFile);
		
		Reader in = Files.newBufferedReader(xmlFilePath, StandardCharsets.UTF_8);
		
		XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
		
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.peek(); 
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				if (startElement.getName().getLocalPart() == (SCHEDULER_DATA)) {
					
					event = eventReader.nextEvent();
				}
				else if (startElement.getName().getLocalPart() == (PATIENT_LIST)) {
					
					event = eventReader.nextEvent(); 
				}
				
				else if (startElement.getName().getLocalPart() == (PATIENT)) {
					Patient p = readPatient(eventReader);
					patientList.add(p);
				}
				else {
					System.err.println("Unrecognized element, ignoring: " + startElement.getName());
					
					
					event = eventReader.nextEvent(); 
				}
			}
			else {
				event = eventReader.nextEvent(); 
				
			}
		}
		
		eventReader.close();
		
		return patientList;
	}
	
	*/

	public static Doctor readDoctor(XMLEventReader eventReader) throws XMLStreamException {
		XMLEvent firstEvent = eventReader.nextEvent(); 
		if (!firstEvent.isStartElement()) {
			throw new IllegalStateException("Attempting to read a doctor but not a start element: found event of type " + firstEvent.getEventType());
		}
		else if (!firstEvent.asStartElement().getName().getLocalPart().equals(DOCTOR)) {
			throw new IllegalStateException("Attempting to read a doctor at the wrong start element: found " + firstEvent.asStartElement().getName());
		}
		 
		int id = 0;
		String ssn = null;
		@SuppressWarnings("unchecked") 
		Iterator<Attribute> attributes = firstEvent.asStartElement().getAttributes();
		while (attributes.hasNext()) {
			Attribute attribute = attributes.next();
			if (attribute.getName().getLocalPart().equals(ID)) {
				id = Integer.valueOf(attribute.getValue()); 
			}
			else if (attribute.getName().getLocalPart().equals(SSN)) {
				ssn = attribute.getValue();
			}
			else {
				System.err.println("Found unknown attribute, ignoring; found: " + attribute.getName());
			}
		}
		
		Doctor doctor = null;
		String name = null;
		String email = null;
		
		String dob1 = null;
		Date dob = null;
		MedicalSpecialty s = null;
		boolean finished = false;
		while (!finished) {
			XMLEvent event = eventReader.peek(); 
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				
				
				if (startElement.getName().getLocalPart().equals(NAME)) {
					name = XMLReaderUtils.readCharacters(eventReader, NAME);
				}		
				else if (startElement.getName().getLocalPart().equals(EMAIL)) {
					email = XMLReaderUtils.readCharacters(eventReader, EMAIL);
				}
				else if (startElement.getName().getLocalPart().equals(DOB)) {
					dob1 = XMLReaderUtils.readCharacters(eventReader, DOB);
					
					dob = XMLReaderUtils.formatter(dob1, DOB_FORMAT);
				}
				else if (startElement.getName().getLocalPart().equals(SPECIALTY)) {
					String specialty = XMLReaderUtils.readCharacters(eventReader, SPECIALTY);
					s = MedicalSpecialty.valueOf(specialty); 
				}
				
				else {
					System.err.println("Unrecognized element, ignoring: " + startElement.getName());
					event = eventReader.nextEvent(); 
				}
			}
			
			else if (event.isEndElement()) {
				event = eventReader.nextEvent(); 
				EndElement endElement = event.asEndElement();
				if (endElement.getName().getLocalPart().equals(DOCTOR)) {
					doctor = new Doctor(id, name,ssn, dob, s, email);
					finished = true;
				}
			}
			else {
				
				event = eventReader.nextEvent(); 
			}
		}
		return doctor;
	}
	
/*	public static ArrayList<Doctor> readDoctors(String xmlFile) throws XMLStreamException, IOException {
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		Path xmlFilePath = Paths.get(xmlFile);
		Reader in = Files.newBufferedReader(xmlFilePath, StandardCharsets.UTF_8);
		XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.peek(); 
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				if (startElement.getName().getLocalPart() == (SCHEDULER_DATA)) {
					
					event = eventReader.nextEvent();
				}
				
				else if (startElement.getName().getLocalPart() == (DOCTOR_LIST)) {
					
					event = eventReader.nextEvent(); 
				}
				else if (startElement.getName().getLocalPart() == (DOCTOR)) {
					Doctor d = readDoctor(eventReader);
					doctorList.add(d);
				}
				else {
					System.err.println("Unrecognized element, ignoring: " + startElement.getName());
					event = eventReader.nextEvent(); 
				}
			}
			else {
				event = eventReader.nextEvent(); 
			}
		}
		eventReader.close();
		return doctorList;
	}
	*/
	public static Visit<String, String> readVisit(XMLEventReader eventReader) throws XMLStreamException {
		
		XMLEvent firstEvent = eventReader.nextEvent(); 
		if (!firstEvent.isStartElement()) {
			throw new IllegalStateException("Attempting to read a doctor but not a start element: found event of type " + firstEvent.getEventType());
		}
		else if (!firstEvent.asStartElement().getName().getLocalPart().equals(VISIT)) {
			throw new IllegalStateException("Attempting to read a doctor at the wrong start element: found " + firstEvent.asStartElement().getName());
		}
		 
		
		Visit<String, String> v = null;
		String host = null;
		String visitor = null;
		
		String dov1 = null;
		Date dov = null;
		
		boolean finished = false;
		while (!finished) {
			XMLEvent event = eventReader.peek();
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				
				if (startElement.getName().getLocalPart().equals(DATE)) {
					dov1 = XMLReaderUtils.readCharacters(eventReader, DATE);
					dov = XMLReaderUtils.formatter(dov1, "dd MMM yyyy" );
		
				}
				
				else if (startElement.getName().getLocalPart().equals(VISITOR)) {
					visitor = XMLReaderUtils.readCharacters(eventReader, VISITOR);
				}
				else if (startElement.getName().getLocalPart().equals(HOST)) {
					host = XMLReaderUtils.readCharacters(eventReader, HOST);
				}
				else {
					System.err.println("Unrecognized element, ignoring: " + startElement.getName());
					event = eventReader.nextEvent(); 
				}
			}
			else if (event.isEndElement()) {
				event = eventReader.nextEvent(); 
				EndElement endElement = event.asEndElement();
				if (endElement.getName().getLocalPart().equals(VISIT)) {
					v = new Visit<String, String>(visitor, host, dov);
					finished = true;
				}
			}
			else {
				
				event = eventReader.nextEvent();
			}
		}
		return v;
	}
	
	/*public static ArrayList<Visit<String, String>> readVisits(String xmlFile) throws XMLStreamException, IOException {
		
		ArrayList<Visit<String, String>> visitList = new ArrayList<Visit<String, String>>();
		
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		
		Path xmlFilePath = Paths.get(xmlFile);
		Reader in = Files.newBufferedReader(xmlFilePath, StandardCharsets.UTF_8);
		XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
		
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.peek(); 
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				if (startElement.getName().getLocalPart() == (SCHEDULER_DATA)) {
					
					event = eventReader.nextEvent();
				}
				
				else if (startElement.getName().getLocalPart() == (VISIT_LIST)) {
					event = eventReader.nextEvent(); 
				}
				else if (startElement.getName().getLocalPart() == (VISIT)) {
					Visit<String, String> v1 = readVisit(eventReader);
					visitList.add(v1);
				}
				else {
					System.err.println("Unrecognized element, ignoring: " + startElement.getName());
					event = eventReader.nextEvent(); 
				}
			}
			else {
				event = eventReader.nextEvent(); 
			}
		}
		eventReader.close();
		
		return visitList;
	}
	
	*/
	public static SchedulerData readSchedulingXML (String xmlFile) throws XMLStreamException, IOException
	{
		Patient pp = null;
		
		Doctor dd = null;
		
		Visit<String,String> vv = null;
		 
		
		ArrayList<Patient> p = new ArrayList<Patient>();
			
		ArrayList<Doctor> d = new ArrayList<Doctor>();
			
		ArrayList<Visit<String, String>> v = new ArrayList<Visit<String, String>>();
		
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		
		Path xmlFilePath = Paths.get(xmlFile);
		Reader in = Files.newBufferedReader(xmlFilePath, StandardCharsets.UTF_8);
		XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
		
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.peek(); 
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				if (startElement.getName().getLocalPart() != PATIENT && startElement.getName().getLocalPart() != DOCTOR && 
						startElement.getName().getLocalPart() != VISIT) {
					
					event = eventReader.nextEvent();
				}
				
				else if (startElement.getName().getLocalPart() == (PATIENT)) {
					
					pp = readPatient(eventReader);
					
					p.add(pp);
						
				}
				else if (startElement.getName().getLocalPart() == (DOCTOR)) {
					
					dd = readDoctor(eventReader);
	
					d.add(dd);
					
				}
				else if (startElement.getName().getLocalPart() == (VISIT)) {
					
					vv = readVisit(eventReader);
					v.add(vv);
				}
				
				else {
					System.err.println("Unrecognized element, ignoring: " + startElement.getName());
					event = eventReader.nextEvent(); 
				}
			}
			else {
				event = eventReader.nextEvent(); 
			}
		}
		eventReader.close();
		
	
		
		ArrayList<Visit<Integer, Integer>> v1 = fillVisitList(p, d, v);
		
		SchedulerData data = new SchedulerData(p,d,v1);
		
		return data;
		
	}
	
	public static ArrayList<Visit<Integer, Integer>> fillVisitList(ArrayList<Patient> p, ArrayList<Doctor> d, ArrayList<Visit<String, String>> v1)
	{
		ArrayList<Visit<Integer, Integer>> vv = new ArrayList<Visit<Integer, Integer>>();
	
		
	
		
		for( Visit<String,String> v2: v1)
		{
			
			int pID = 0;
			
			int dID = 0;
			
			for(Patient pp: p)
			{
				if(v2.getVisitor().equals(pp.getSSN()))
				{
					pID = pp.getPatientID();
				}
			}
			
			
			for(Doctor dd: d)
			{
				if(v2.getHost().equals(dd.getSSN()))
				{
					dID = dd.getDoctorID();
				}
			}
			
			
			Visit<Integer,Integer> vvv = new Visit<Integer,Integer>(pID, dID, v2.getDateOfVisit());
			
			vv.add(vvv);
			
			
		}
		
		return vv;
	}
	
	
	

}
