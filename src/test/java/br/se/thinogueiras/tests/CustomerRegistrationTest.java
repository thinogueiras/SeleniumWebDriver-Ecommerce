package br.se.thinogueiras.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.se.thinogueiras.core.BaseTest;
import br.se.thinogueiras.pages.CustomerRegistrationPage;

public class CustomerRegistrationTest extends BaseTest
{
	private CustomerRegistrationPage page = new CustomerRegistrationPage();
	
	@Test
	public void registration() 
	{
		page.accessLoginPage();
		page.setNewEmailAccount("teste2021@teste.com");
		page.clickCreateAnAaccountButton();
		assertEquals("CREATE AN ACCOUNT", page.validateScreenTitleCreateAnAccount("CREATE AN ACCOUNT"));
		page.setGender();
		page.setFirstName("Thiago");		
	}
	
	@Test
	public void checkRegistrationSuccessfuly()
	{
		
	}
}
