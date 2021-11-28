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
		page.setMaleGender();
		page.setFirstName("Thiago");
		page.setLastName("Santos");
		page.setPassword("teste@123");
		page.selectBirthDate("14111989");
		page.clickCheckBoxNewsletter();
		page.clickCheckBoxSpecialOffersFromPartners();
		page.setCompanyName("Test Automation S/A");
		page.setAddress("Rua do teste, 123");
		page.setCity("Ribeirão Preto");
		page.setState("Texas");
		page.setZipPostalCode("14092470");
		page.setCountry("United States");
		page.setAdditionalInformation("Teste");
		page.setMobileNumber("11999999999");
		page.setAddressAlias("teste2020@teste.com");
	}
	
	@Test
	public void checkRegistrationSuccessfuly()
	{
		
	}
}
