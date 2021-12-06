package br.se.thinogueiras.core;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	private WebElement element;
	private WebDriverWait wait;
	
	public static void accessPage()
	{
		getDriver().get("http://automationpractice.com/index.php");
	}
		
	public void sendText(String id, String text)
	{
		getDriver().findElement(By.id(id)).sendKeys(text);
	}
	
	public void clearField(String id)
	{
		getDriver().findElement(By.id(id)).clear();
	}
	
	public void sendText(String xPath)
	{
		getDriver().findElement(By.xpath(xPath));
	}
	
	public void sendText(String id, int value)
	{
		getDriver().findElement(By.id(id)).sendKeys(String.valueOf(value));
	}	
	
	public void clickById(String id)
	{
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clickByName(String name)
	{
		getDriver().findElement(By.name(name)).click();
	}
	
	public void clickByXpath(String xpath)
	{
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void clickByLinkText(String link)
	{
		getDriver().findElement(By.linkText(link)).click();
	}
	
	public String getElementText(String xPath)
	{
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
	    String text = element.getText();
		return text;
	}
	
	public String getTextFields(String id)
	{
		return getDriver().findElement(By.id(id)).getAttribute("value");	    
	}
	
	public String getScreenTitle(String xPath, String textCheck)
	{		
		element = getDriver().findElement(By.xpath(xPath));
		String text = element.getText();
		if(text.contains(textCheck))
		{
			return textCheck;
		}
		else
		{
			return text;			
		}
	}
	
	public void clickRadioButton(String id)
	{
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).click();		
	}
	
	public void selectComboField(String id, int value)
	{
		getDriver().findElement(By.id(id)).sendKeys(String.valueOf(value));		
	}
	
	public void selectComboField(String id, String value)
	{
		getDriver().findElement(By.id(id)).sendKeys(value);		
	}
	
	public void sendNumbers(String id, int value)
	{
		getDriver().findElement(By.id(id)).sendKeys(String.valueOf(value));
	}	
}
