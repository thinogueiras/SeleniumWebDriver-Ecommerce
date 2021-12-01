package br.se.thinogueiras.tests;

import static br.se.thinogueiras.pages.LoginPage.accessLoginPage;
import static br.se.thinogueiras.pages.LoginPage.accessPage;
import static br.se.thinogueiras.pages.LoginPage.clickOnSignOut;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.se.thinogueiras.core.BaseTest;
import br.se.thinogueiras.pages.LoginPage;

public class LoginTest extends BaseTest
{
	private static LoginPage page = new LoginPage();
	
	@Before
	public void setUp() 
	{
		accessPage();
	}
	
	@Test	
	public void loginSuccessfully()
	{
		accessLoginPage();
		page.setEmailAddress("teste2021@teste.com");
		page.setPassword("teste@123");
		page.clickOnSignInButton();
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", 
				page.checkMessageWelcomeToYourAccount());
		clickOnSignOut();
	}
	
	@Test
	public void checkInvalidCredentials()
	{
		accessLoginPage();
		page.setEmailAddress("teste@teste.com.br");
		page.setPassword("teste@123");
		page.clickOnSignInButton();
		assertEquals("Authentication failed.", page.getMessageLoginError());		
	}
}
