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
}
