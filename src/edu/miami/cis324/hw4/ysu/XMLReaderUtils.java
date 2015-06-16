package edu.miami.cis324.hw4.ysu;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public abstract class XMLReaderUtils {
	
	public static String readCharacters(XMLEventReader eventReader, String elementName) throws XMLStreamException {
		XMLEvent firstEvent = eventReader.nextEvent(); // gets the next event
		// first make sure that the current event is the start element of name
		if (!firstEvent.isStartElement()) {
			throw new IllegalStateException("Attempting to read a " + elementName + " but not a start element: found event of type " + firstEvent.getEventType());
		}
		else if (!firstEvent.asStartElement().getName().getLocalPart().equals(elementName)) {
			throw new IllegalStateException("Attempting to read a " + elementName + " at the wrong start element: found " + firstEvent.asStartElement().getName());
		}
		String chars = eventReader.nextEvent().asCharacters().getData();
		return chars;
	}

	

	public static int calculateAge(Date dateOfBirth)
	{
		Calendar dob = Calendar.getInstance();  
		dob.setTime(dateOfBirth);  
		Calendar today = Calendar.getInstance();  
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
		if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))  
		age--;  
		return age;  
	}
	
	public static String DateToString (String format, Date dd)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
	    String stringDate = sdf.format(dd);
	    
	    return stringDate;
	}


	public static Date formatter (String date, String formatter)
	{
		Date date1 = null;
		
		SimpleDateFormat df = new SimpleDateFormat(formatter);
		
	 
		try {
	 
			date1 = df.parse(date);
			
	 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date1;
	}
	
	
	public static long differenceBetweenDates (Date d1, Date d2)
	{
		
		long diff = d2.getTime() - d1.getTime();
		
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		return diffDays;
	}

}


