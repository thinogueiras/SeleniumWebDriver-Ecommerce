package br.se.thinogueiras.core;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class Utils 
{
	public static String getMonth(int month) 
	{		
		return new DateFormatSymbols(Locale.US).getMonths()[month-1];				
	}
}
