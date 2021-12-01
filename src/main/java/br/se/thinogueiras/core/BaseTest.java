package br.se.thinogueiras.core;

import static br.se.thinogueiras.core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTest 
{	
	@After	
	public void closeBrowser()
	{
		if(Properties.closeBrowser)
		{
			killDriver();			
		}
	}
}
