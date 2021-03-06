package edu.miami.cis324.hw4.ysu;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;


public class SchedulerWriterUtils extends ReadWriteUtils{
	
	private final static String NAMESPACE = "http://www.miami.edu/cis324/xml/scheduling";
	private final static String SCHEMA_INSTANCE_PREFIX = "xsi";
	private final static String SCHEMA_INSTANCE_NS = "http://www.w3.org/2001/XMLSchema-instance";
	private final static String SCHEMA_LOCATION_ATTRNAME = "schemaLocation";
	private final static String SCHEMA_FILE_NAME = "scheduling.xsd";
	
	/*public static void writeName(XMLEventFactory eventFactory, XMLEventWriter eventWriter, Name studentName, int level) throws XMLStreamException {
		// first, write as many tabs as levels needed
		eventWriter.add(XMLWriterUtils.getIndentation(eventFactory, level));
		// start element
		eventWriter.add(eventFactory.createStartElement("", "", NAME));
		eventWriter.add(eventFactory.createIgnorableSpace("\n")); // line feed for readability
		// first name
		XMLWriterUtils.writeNode(eventFactory, eventWriter, FIRST_NAME, studentName.getFirstName(), level+1);
		// last name
		XMLWriterUtils.writeNode(eventFactory, eventWriter, LAST_NAME, studentName.getLastName(), level+1);
		// end element
		eventWriter.add(XMLWriterUtils.getIndentation(eventFactory, level)); // also indent it
		eventWriter.add(eventFactory.createEndElement("", "", NAME));
		eventWriter.add(eventFactory.createIgnorableSpace("\n")); // line feed for readability
	}
*/
	public static void writePatient(XMLEventFactory eventFactory, XMLEventWriter eventWriter, Patient p, int level) throws XMLStreamException {
		// writes a single student through to the XML event writer
		// create the student start element
		eventWriter.add(XMLWriterUtils.getIndentation(eventFactory, level));
	    StartElement patientStart = eventFactory.createStartElement("", "", PATIENT);
	    eventWriter.add(patientStart);
	    // create the id attribute
	    // note the use of Integer.toString to get a string representation
	    Attribute patientId = eventFactory.createAttribute(ID, Integer.toString(p.getPatientID()));
	    eventWriter.add(patientId);
	    // create the SSN attribute
	    Attribute patientSSN = eventFactory.createAttribute(SSN, p.getSSN());
	    eventWriter.add(patientSSN);
		eventWriter.add(eventFactory.createIgnorableSpace("\n")); // line feed for readability
	    // now create the nested elements
	    XMLWriterUtils.writeNode(eventFactory, eventWriter, NAME, p.getPatientName(), level);
	    XMLWriterUtils.writeNode(eventFactory, eventWriter, EMAIL, p.getEmail(), level + 1);
	    XMLWriterUtils.writeDate(eventFactory, eventWriter, DOB, XMLWriterUtils.DateToCalendar(p.getDob()), level + 1);
	    // create the student end element
		eventWriter.add(XMLWriterUtils.getIndentation(eventFactory, level));
	    EndElement patientEnd = eventFactory.createEndElement("", "", PATIENT);
	    eventWriter.add(patientEnd);
	}
	
	public static void writeDoctor(XMLEventFactory eventFactory, XMLEventWriter eventWriter, Doctor d, int level) throws XMLStreamException {
		// writes a single student through to the XML event writer
		// create the student start element
		eventWriter.add(XMLWriterUtils.getIndentation(eventFactory, level));
	    StartElement doctorStart = eventFactory.createStartElement("", "", DOCTOR);
	    eventWriter.add(doctorStart);
	    // create the id attribute
	    // note the use of Integer.toString to get a string representation
	    Attribute doctorId = eventFactory.createAttribute(ID, Integer.toString(d.getDoctorID()));
	    eventWriter.add(doctorId);
	    // create the SSN attribute
	    Attribute doctorSSN = eventFactory.createAttribute(SSN, d.getSSN());
	    eventWriter.add(doctorSSN);
		eventWriter.add(eventFactory.createIgnorableSpace("\n")); // line feed for readability
	    // now create the nested elements
	    XMLWriterUtils.writeNode(eventFactory, eventWriter, NAME, d.getDoctorName(), level);
	    XMLWriterUtils.writeNode(eventFactory, eventWriter, EMAIL, d.getEmail(), level + 1);
	    XMLWriterUtils.writeDate(eventFactory, eventWriter, DOB, XMLWriterUtils.DateToCalendar(d.getDob()), level + 1);
	    // create the student end element
		eventWriter.add(XMLWriterUtils.getIndentation(eventFactory, level));
	    EndElement doctorEnd = eventFactory.createEndElement("", "", DOCTOR);
	    eventWriter.add(doctorEnd);
	}

	
	public static void writeVisit(XMLEventFactory eventFactory, XMLEventWriter eventWriter, Visit<String,String> v, int level) throws XMLStreamException {
		// writes a single student through to the XML event writer
		// create the student start element
		eventWriter.add(XMLWriterUtils.getIndentation(eventFactory, level));
	    StartElement visitStart = eventFactory.createStartElement("", "", VISIT);
	    eventWriter.add(visitStart);
	   
	    XMLWriterUtils.writeNode(eventFactory, eventWriter, HOST, v.getHost(), level);
	    XMLWriterUtils.writeNode(eventFactory, eventWriter, VISITOR, v.getVisitor(), level + 1);
	    XMLWriterUtils.writeDate(eventFactory, eventWriter, DATE, XMLWriterUtils.DateToCalendar(v.getDateOfVisit()), level + 1);
		eventWriter.add(XMLWriterUtils.getIndentation(eventFactory, level));
	    EndElement visitEnd = eventFactory.createEndElement("", "", VISIT);
	    eventWriter.add(visitEnd);
	}
	
	
	public static void writeSchedulerData(String outFile, ArrayList<Patient> p, ArrayList<Doctor> d, ArrayList<Visit<String,String>> v) throws XMLStreamException, IOException {
	    // Create a XMLOutputFactory
	    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
	    // Create XMLEventWriter
	    Path outputFilePath = Paths.get(outFile);
	    Writer outputFile = Files.newBufferedWriter(outputFilePath, StandardCharsets.UTF_8);
	    XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(outputFile);
	    // Create an XMLEventFactory
	    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	    // Create and write Start Tag
	    StartDocument startDocument = eventFactory.createStartDocument("UTF-8", "1.0");
	    eventWriter.add(startDocument);
	    // put a linefeed for readability
	    eventWriter.add(eventFactory.createIgnorableSpace("\n"));
	    // create the root element
	    StartElement root = eventFactory.createStartElement("", "", SCHEDULER_DATA);
		eventWriter.add(root);
	    eventWriter.setDefaultNamespace(SchedulerWriterUtils.NAMESPACE); // set the default namespace for the root before adding it
		// add any other namespaces to the root
	    eventWriter.add(eventFactory.createNamespace(NAMESPACE));
	    eventWriter.add(eventFactory.createNamespace(SCHEMA_INSTANCE_PREFIX, SCHEMA_INSTANCE_NS));
	    // add the schema attributes to the root element 
	    String schemaLocationArg = NAMESPACE + " " + SCHEMA_FILE_NAME;
	    eventWriter.add(eventFactory.createAttribute(SCHEMA_INSTANCE_PREFIX, SCHEMA_INSTANCE_NS, SCHEMA_LOCATION_ATTRNAME, schemaLocationArg));
	    // put a linefeed for readability
	    eventWriter.add(eventFactory.createIgnorableSpace("\n"));
	    
	    eventWriter.add(eventFactory.createStartElement("", "", PATIENT_LIST));
	   
	    
		// iterate over the list of students and create an element for each
		
	    for (Patient pp : p) {
			writePatient(eventFactory, eventWriter, pp, 1); // write the student with one level of indentation
		    eventWriter.add(eventFactory.createIgnorableSpace("\n"));
		}
	   
	   
		
		for (Doctor dd : d)
		{
			writeDoctor(eventFactory, eventWriter, dd, 1);	
			eventWriter.add(eventFactory.createIgnorableSpace("\n"));
		}
		
		
		for(Visit<String, String> vv: v)
		{
			writeVisit(eventFactory, eventWriter, vv, 1);	
			eventWriter.add(eventFactory.createIgnorableSpace("\n"));
		}
		
		
		
		eventWriter.add(eventFactory.createEndDocument());
		
		eventWriter.close();
	    
	
		
	}



}
