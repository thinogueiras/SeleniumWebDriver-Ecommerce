package br.se.thinogueiras.core;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	private WebElement element;
	private WebDriverWait wait;
		
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
	
	public void clickByXpath(String xpath)
	{
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public String getElementText(String xPath)
	{
		wait = new WebDriverWait(getDriver(), 30);
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
		wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).click();				
	}
	
	public void selectComboField(String id, String value)
	{
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(value);		
	}
	
	public void selectComboField(String id, int value)
	{
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);		
		combo.selectByIndex(value);		
	}
	
	public void selectComboFieldYear(String id, int value)
	{
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		if(value == 1989)
		{
			combo.selectByIndex(33);
		}		
	}
	
	public int getComboFieldYearIndex(int year)
	{
		int index = 0;
		int[][] arrayAnos = new int[100][2];
		for(int i = 0; i <= arrayAnos.length; ++i)
		{
			for(int j = 0; j <= arrayAnos[i].length; ++j)
			{
				arrayAnos[i][i] = Calendar.getInstance().get(Calendar.YEAR);
				arrayAnos[j][j] = j;
			}
		}
		
		return index;
	}
	
	public void sendNumbers(String id, int value)
	{
		getDriver().findElement(By.id(id)).sendKeys(String.valueOf(value));
	}	
	
	public String getValueComboField(String id)
	{
		element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}	
}
