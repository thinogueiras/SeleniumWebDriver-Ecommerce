package br.se.thinogueiras.tests;

import static br.se.thinogueiras.pages.CustomerRegistrationPage.accessPage;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.se.thinogueiras.core.BaseTest;
import br.se.thinogueiras.pages.CustomerRegistrationPage;

public class CustomerRegistrationTest extends BaseTest
{
	private CustomerRegistrationPage page;
	
	@Before
	public void setUp()
	{
		page = new CustomerRegistrationPage();
		accessPage();
	}
	
	@Test
	public void customerRegister() 
	{
		page.accessLoginPage();
		page.setNewEmailAccount();
		page.clickOnCreateAnAccountButton();
		assertEquals("CREATE AN ACCOUNT", page.validateScreenTitleCreateAnAccount("CREATE AN ACCOUNT"));
		page.setMaleGender();
		page.setFirstName("Thiago");
		page.setLastName("Santos");
		page.setPassword("teste@123");
		page.setBirthDate(14, "November", 1989);
		page.clickCheckBoxNewsletter();
		page.clickCheckBoxSpecialOffersFromPartners();
		page.setCompanyName("Test Automation S/A");
		page.setAddress("Rua do teste, 123");
		page.setCity("Ribeirão Preto");
		page.setState("Texas");
		page.setZipPostalCode("00000");
		page.setCountry("United States");
		page.setAdditionalInformation("Teste");
		page.setMobileNumber("11999999999");
		page.setAddressAlias("teste2020@teste.com");
		page.clickRegisterButton();
		
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", 
				page.checkSuccessfulyRegister());
	}
	
	@Test
	public void checkAccountExists()
	{
		page.accessLoginPage();
		page.setNewEmailAccount("teste2021@teste.com");
		page.clickOnCreateAnAccountButton();
		assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", 
				page.checkCustomerExists());
	}
	
	@Test
	public void checkCustomerAccountRegister()
	{
		page.accessLoginPage();
		page.setEmailAddress("teste2021@teste.com");
		page.setPassword("teste@123");
		page.clickOnSignInButton();
		page.clickOnMyPersonalInformationButton();
		assertEquals("teste2021@teste.com", page.getTextEmailField());
	}
}
