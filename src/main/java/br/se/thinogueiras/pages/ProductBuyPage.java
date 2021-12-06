package br.se.thinogueiras.pages;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.se.thinogueiras.core.BasePage;

public class ProductBuyPage extends BasePage
{
	private WebDriverWait wait;
	private WebElement element;	
	
	public void accessLoginPage()
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

	public void clickOnTshirtsMenu() 
	{		
		clickByXpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
	}

	public void clickOnProductFadedShort() 
	{
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")));
		element.click();				
	}
	
	public void clickOnAddToCartButton()
	{
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")));
		element.click();				
	}

	public void clickOnContinueShoppingButton() 
	{
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")));
		element.click();		
	}
	
	public void clickOnDressesMenu()
	{
		clickByXpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	}

	public void clickOnProductPrintedDress()
	{
		clickByXpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img");		
	}

	public void clickOnProceedToCheckoutButton1()
	{
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")));
		element.click();			
	}
	
	public void clickOnProceedToCheckoutButton2()
	{
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")));
		element.click();		
	}

	public void clickOnProceedToCheckoutButton3() 
	{
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")));
		element.click();				
	}
	
	public void clickOnTermsOfService()
	{
		clickByName("cgv");
	}
	
	public void clickOnProceedToCheckoutButton4()
	{
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/p/button/span")));
		element.click();		
	}
	
	public void clickOnPayByBankWire()
	{
		clickByXpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
	}
	
	public void clickOnConfirmMyOrder()
	{
		clickByXpath("//*[@id=\"cart_navigation\"]/button/span");
	}
	
	public String checkOrderMessage()
	{
		return getElementText("//*[@id=\"center_column\"]/div/p/strong");
	}	
}
