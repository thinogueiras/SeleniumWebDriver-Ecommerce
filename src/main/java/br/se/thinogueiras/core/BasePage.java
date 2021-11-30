package br.se.thinogueiras.core;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	private static WebElement element;
	private static WebDriverWait wait;	
		
	public static void sendText(String id, String text)
	{
		getDriver().findElement(By.id(id)).sendKeys(text);
	}
	
	public static void clearField(String id)
	{
		getDriver().findElement(By.id(id)).clear();
	}
	
	public static void sendText(String xPath)
	{
		getDriver().findElement(By.xpath(xPath));
	}
	
	public void sendText(String id, int value)
	{
		getDriver().findElement(By.id(id)).sendKeys(String.valueOf(value));
	}	
	
	public static void clickById(String id)
	{
		getDriver().findElement(By.id(id)).click();
	}
	
	public static void clickByName(String name)
	{
		getDriver().findElement(By.name(name)).click();
	}
	
	public static void clickByXpath(String xpath)
	{
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public static void clickByLinkText(String link)
	{
		getDriver().findElement(By.linkText(link)).click();
	}
	
	public String getElementText(String xPath)
	{
		wait = new WebDriverWait(getDriver(), 10);
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
	
	public static void clickRadioButton(String id)
	{
		wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).click();		
	}
	
	public static void selectComboField(String id, String value)
	{
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(value);		
	}
	
	public static void selectComboField(String id, int value)
	{
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);		
		combo.selectByIndex(value);		
	}
	
	public static void selectComboFieldYear(String id, int value)
	{
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);		
		combo.selectByIndex(33);				
	}	
	
	public void sendNumbers(String id, int value)
	{
		getDriver().findElement(By.id(id)).sendKeys(String.valueOf(value));
	}	
}
