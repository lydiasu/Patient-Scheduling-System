package edu.miami.cis324.hw4.ysu;


public enum MedicalSpecialty {
	
	GENERAL_MEDICINE, PEDIATRICS, ONCOLOGY;
	
	public MedicalSpecialty getFromString(String s)
	{
		
		
		if (s == MedicalSpecialty.GENERAL_MEDICINE.toString())
		{
			return GENERAL_MEDICINE;
		}
		else if(s == MedicalSpecialty.PEDIATRICS.toString())
		{
			return PEDIATRICS;
		}
		else
		{
			return ONCOLOGY;
		}
		
		
	}

}
