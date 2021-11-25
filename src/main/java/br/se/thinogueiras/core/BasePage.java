package br.se.thinogueiras.core;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
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
	
	public void clickByName(String name)
	{
		getDriver().findElement(By.name(name)).click();
	}	
	
	public void findByXpathAndSendKeys(String xPath, String text)
	{
		getDriver().findElement(By.xpath(xPath)).sendKeys(text);
	}	
	
	public void clickByLinkText(String linkText)
	{
		getDriver().findElement(By.linkText(linkText)).click();
	}
	
	public void clickByXpath(String xpath)
	{
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void selectComboField(String id, String value)
	{
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(value);
	}
	
	public String getValueComboField(String id)
	{
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public String getTextElementWithWait(String xPath)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 3);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
	    String text = element.getText();
		return text;
	}

}
