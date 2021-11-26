package br.se.thinogueiras.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.se.thinogueiras.core.BaseTest;
import br.se.thinogueiras.pages.LoginPage;

public class LoginTest extends BaseTest
{
	private LoginPage page = new LoginPage();
	
	@Test	
	public void loginSuccessfully()
	{
		page.accessLoginPage();
		page.setEmailAddress("thiago1@teste.com.br");
		page.setPassword("thiago1@123");
		page.clickOnSignInButton();
	}
	
	@Test
	public void checkInvalidCredentials()
	{
		page.accessLoginPage();
		page.setEmailAddress("teste@teste.com.br");
		page.setPassword("teste@123");
		page.clickOnSignInButton();
		assertEquals("Authentication failed.", page.getMessageLoginError());		
	}
}
