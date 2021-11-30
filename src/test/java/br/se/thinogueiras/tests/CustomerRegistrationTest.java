package br.se.thinogueiras.tests;

import static br.se.thinogueiras.pages.CustomerRegistrationPage.accessLoginPage;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.clickCheckBoxNewsletter;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.clickCheckBoxSpecialOffersFromPartners;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.clickOnCreateAnAccountButton;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.clickOnMyPersonalInformationButton;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.clickOnSignInButton;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.clickRegisterButton;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.selectBirthDate;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.setAddress;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.setAddressAlias;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.setCity;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.setCompanyName;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.setEmailAddress;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.setMaleGender;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.setPassword;
import static br.se.thinogueiras.pages.CustomerRegistrationPage.setState;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import br.se.thinogueiras.core.BaseTest;
import br.se.thinogueiras.pages.CustomerRegistrationPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerRegistrationTest extends BaseTest
{
	private static CustomerRegistrationPage page = new CustomerRegistrationPage();
	
	@Before
	public void setUp()
	{
		accessLoginPage();
	}
	
	@Test
	public void test1_registration() 
	{
		page.setNewEmailAccount();
		clickOnCreateAnAccountButton();
		assertEquals("CREATE AN ACCOUNT", page.validateScreenTitleCreateAnAccount("CREATE AN ACCOUNT"));
		setMaleGender();
		page.setFirstName("Thiago");
		page.setLastName("Santos");
		setPassword("teste@123");
		selectBirthDate("14111989");
		clickCheckBoxNewsletter();
		clickCheckBoxSpecialOffersFromPartners();
		setCompanyName("Test Automation S/A");
		setAddress("Rua do teste, 123");
		setCity("Ribeirão Preto");
		setState("Texas");
		page.setZipPostalCode("00000");
		page.setCountry("United States");
		page.setAdditionalInformation("Teste");
		page.setMobileNumber("11999999999");
		setAddressAlias("teste2020@teste.com");
		clickRegisterButton();
		
		assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", 
				page.checkSuccessfulyRegister());
	}
	
	@Test
	public void test2_checkAccountExists()
	{
		page.setNewEmailAccount("teste2021@teste.com");
		clickOnCreateAnAccountButton();
		assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", 
				page.checkCustomerExists());
	}
	
	@Test
	public void test3_checkCustomerAccountRegister()
	{
		setEmailAddress("teste2021@teste.com");
		setPassword("teste@123");
		clickOnSignInButton();
		clickOnMyPersonalInformationButton();
		assertEquals("teste2021@teste.com", page.getTextEmailField());
	}
}
