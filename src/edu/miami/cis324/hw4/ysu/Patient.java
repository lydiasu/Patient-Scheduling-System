package edu.miami.cis324.hw4.ysu;


import java.util.Date;


public class Patient {
	
private int patientID;
	
	private String patientName;
	
	private String email;
	
	private String SSN;
	
	private Date dob;
	
	private int age;
	
	private final static String DOB_FORMAT = "MMM dd yyyy";
	
	
	public Patient(int patientID, String patientName, String SSN, Date dob, String email){
		
		this.patientID = patientID;
		
		this.patientName = patientName;
		
		this.SSN = SSN;
		
		this.dob = dob;
		
		this.email = email;
		
	}
	
public String getPatientLname(){
		
		String temp[] = this.patientName.split(" ");
		
		String lname;
		
		
		lname = temp[1];
		
		return lname;
	}
	
	
	public String getPatientFname(){
		
		
		String temp[] = this.patientName.split(" ");
		
		String fname;
		
		fname = temp[0];
		
		return fname;
	}
	
	
	public String getEmail()
	{
		return email;
	}
	
	public int getPatientID()
	{
		return patientID;
	}
	
	public String getPatientName(){
		
		return patientName;
	}
	
	
	public String getSSN(){
		return SSN;
	}
	
	public Date getDob(){
		
		return dob;
	}
	
	public int getAge(){
		return age;
	}
	
	
	@Override
	public String toString() {
		
	
		
		return "Patient\nID=" + patientID + "\nName=" + patientName + "\nssn=" + SSN + "\nEmail=" + email + "\ndob=" + XMLReaderUtils.DateToString(DOB_FORMAT, dob);
	}


}
