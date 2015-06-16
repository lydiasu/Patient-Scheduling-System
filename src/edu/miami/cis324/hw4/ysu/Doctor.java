package edu.miami.cis324.hw4.ysu;

import java.util.Date;



public class Doctor {
	
	

	private int doctorID;
	
	private String email;
	
	private String doctorName;

	
	private String SSN;
	
	private Date dob;

	private MedicalSpecialty s;
	
	private final static String DOB_FORMAT = "MMM dd yyyy";
	
	public Doctor(int doctorID, String doctorName, String SSN, Date dob, MedicalSpecialty s, String email )
	{
		
		this.doctorID = doctorID;
		
		this.email =email;
		
		this.doctorName = doctorName;
		
		this.SSN = SSN;
		
		this.dob =dob;
		
		this.s = s;
	}
	
	public String getDoctorFname(){
		

		String temp[] = this.doctorName.split(" ");
		
		String fname;
		
		
		fname = temp[0];
		
		return fname;
	}
	
	
	public String getDoctorLname(){
		
		String temp[] = this.doctorName.split(" ");
		
		String lname;
		
		
		lname = temp[1];
		
		return lname;
	}
	
	

	public String getEmail()
	{
		return email;
	}
	
	public Date getDob()
	{
		return dob;
	}
	
	public int getDoctorID(){
		
		return doctorID;
	}
	
	public String getDoctorName(){
		
		return doctorName;
	}
	

	public String getSSN()
	{
		return SSN;
	}
	
	public MedicalSpecialty getSpecialty()
	{
		
		return s;
	}

	@Override
	public String toString() {
		
	
		
		return "Doctor\nID=" + doctorID + "\nName=" + doctorName + "\nssn=" + SSN + "\nEmail=" + email + "\ndob=" + XMLReaderUtils.DateToString(DOB_FORMAT, dob);
	}


	

}
