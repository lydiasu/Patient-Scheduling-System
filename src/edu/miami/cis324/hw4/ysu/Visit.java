package edu.miami.cis324.hw4.ysu;



import java.util.Date;


public class Visit<V,T> {
	

	private V visitor;
	
	private T host;
	
	private Date dov;

	private final static String VD_FORMAT = "dd/MMM/yyyy";
	public Visit(V visitor, T host, Date dov)
	{
		this.visitor = visitor;
		
		this.host = host;
		
		this.dov = dov;
	}

	public V getVisitor()
	{
		return visitor;
	}
	
	public T getHost()
	{
		return host;
	}
	
	public Date getDateOfVisit()
	{
		return dov;
	}

	
	
	@Override
	public String toString() {
		
		
		return "Patient ID = " + visitor + "\nDoctor ID = " + host +"\nVisitDate = " + XMLReaderUtils.DateToString(VD_FORMAT, dov) ;
	}



	

}
