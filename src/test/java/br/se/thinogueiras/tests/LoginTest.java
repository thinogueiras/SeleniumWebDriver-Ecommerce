package br.se.thinogueiras.tests;

import org.junit.Test;

import br.se.thinogueiras.core.BaseTest;
import br.se.thinogueiras.pages.LoginPage;

public class LoginTest extends BaseTest
{
	private LoginPage page = new LoginPage();
	
	@Test
	public void login()
	{
		page.accessLoginPage();
		page.setEmailAddress("thiago1@teste.com.br");
		page.setPassword("thiago1@123");
		page.clickOnSignInButton();
	}
}
