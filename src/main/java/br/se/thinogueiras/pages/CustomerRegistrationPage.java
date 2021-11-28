package br.se.thinogueiras.pages;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import br.se.thinogueiras.core.BasePage;
import br.se.thinogueiras.core.Browser;

public class CustomerRegistrationPage extends BasePage 
{
	public void accessLoginPage()
	{
		getDriver(Browser.Chrome, false).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	public void setNewEmailAccount(String text)
	{
		sendText("email_create", text);
	}
	
	public void clickCreateAnAaccountButton()
	{
		clickByXpath("//*[@id=\"SubmitCreate\"]/span");
	}
	
	public String validateScreenTitleCreateAnAccount(String textCheck)
	{
		return getScreenTitle("//*[@id=\"columns\"]/div[3]", textCheck);
	}
	
	public void setMaleGender()
	{
		clickRadioButton("id_gender1");
	}
	
	public void setFemaleGender()
	{
		clickRadioButton("id_gender2");
	}
	
	public void setFirstName(String firstName)
	{		
		sendText("customer_firstname", firstName);;
	}
	
	public void setLastName(String lastName)
	{
		sendText("customer_lastname", lastName);
	}
	
	public void setPassword(String password)
	{
		sendText("passwd", password);
	}	
	
	public void selectBirthDate(String birthDate)
	{
		int day = Integer.parseInt(birthDate.substring(0, 2));
		int month = Integer.parseInt(birthDate.substring(2, 4));
		int year = Integer.parseInt(birthDate.substring(4));		
		selectComboField("days", day);		
		selectComboField("months", month);
		selectComboFieldYear("years", year);		
	}
	
	public void clickCheckBoxNewsletter()
	{
		clickById("newsletter");
	}
	
	public void clickCheckBoxSpecialOffersFromPartners()
	{
		clickById("optin");
	}		 
	
	public void setCompanyName(String companyName)
	{
		sendText("company", companyName);
	}
	
	public void setAddress(String address)
	{
		sendText("address1", address);
	}
	
	public void setCity(String city)
	{
		sendText("city", city);
	}
	
	public void setState(String text)
	{
		selectComboField("id_state", text);
	}
	
	public void setZipPostalCode(String text)
	{
		sendText("postcode", text);
	}
	
	public void setCountry(String country)
	{
		selectComboField("id_country", country);		
	}
	
	public void setAdditionalInformation(String text)
	{
		sendText("other", text);
	}
	
	public void setMobileNumber(String text)
	{
		sendText("phone_mobile", text);
	}
	
	public void setAddressAlias(String text)
	{
		clearField("alias");
		sendText("alias", text);
	}
	
	public void clickRegisterButton()
	{
		clickByXpath("//*[@id=\"submitAccount\"]/span");
	}
}
