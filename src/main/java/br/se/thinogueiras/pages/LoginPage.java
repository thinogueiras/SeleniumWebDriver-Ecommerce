package br.se.thinogueiras.pages;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import br.se.thinogueiras.core.BasePage;
import br.se.thinogueiras.core.Browser;

public class LoginPage extends BasePage
{
	public void accessLoginPage()
	{
		getDriver(Browser.Chrome, false).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
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
	
	public String getMessageLoginError()
	{
		return getMessageAlertText("//*[@id=\"center_column\"]/div[1]/ol/li");		
	}
}
