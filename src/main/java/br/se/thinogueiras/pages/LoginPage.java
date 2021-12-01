package br.se.thinogueiras.pages;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import br.se.thinogueiras.core.BasePage;

public class LoginPage extends BasePage
{
	public static void accessPage()
	{
		getDriver().get("http://automationpractice.com/index.php");
	}
	
	public static void accessLoginPage()
	{
		clickByXpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	}
	
	public void setEmailAddress(String email)
	{
		sendText("email", email);
	}
	
	public void setPassword(String password)
	{
		sendText("passwd", password);
	}
	
	public void clickOnSignInButton()
	{
		clickByXpath("//*[@id=\"SubmitLogin\"]/span");		
	}
	
	public void signIn(String email, String password)
	{
		setEmailAddress(email);
		setPassword(password);
		clickOnSignInButton();
	}
	
	public String checkMessageWelcomeToYourAccount() 
	{
		return getElementText("//*[@id=\"center_column\"]/p");
	}
	
	public String getMessageLoginError()
	{
		return getElementText("//*[@id=\"center_column\"]/div[1]/ol/li");		
	}

	public static void clickOnSignOut() 
	{		
		clickByXpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
	}	
}
