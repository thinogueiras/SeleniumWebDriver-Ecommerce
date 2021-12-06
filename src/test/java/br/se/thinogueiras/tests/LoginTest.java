package br.se.thinogueiras.tests;

import static br.se.thinogueiras.pages.LoginPage.accessPage;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.se.thinogueiras.core.BaseTest;
import br.se.thinogueiras.pages.LoginPage;

public class LoginTest extends BaseTest
{
	private LoginPage page;
	
	@Before
	public void setUp() 
	{
		page = new LoginPage();
		accessPage();
	}
	
	@Test	
	public void loginSuccessfully()
	{
		page.accessLoginPage();
		page.setEmailAddress("teste2021@teste.com");
		page.setPassword("teste@123");
		page.clickOnSignInButton();
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", 
				page.checkMessageWelcomeToYourAccount());
		page.clickOnSignOut();
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
