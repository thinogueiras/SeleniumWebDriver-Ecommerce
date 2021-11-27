package br.se.thinogueiras.core;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	private WebElement element;		
	
	public void sendText(String id, String text)
	{
		getDriver().findElement(By.id(id)).sendKeys(text);
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
	
	public void clickByXpath(String xpath)
	{
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public String getElementText(String xPath)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
	    String text = element.getText();
		return text;
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
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).click();				
	}	
}
