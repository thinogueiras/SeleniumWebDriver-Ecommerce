package br.se.thinogueiras.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory 
{
	private static WebDriver driver;

    private DriverFactory()
    {
    	
    }

    public static WebDriver getDriver()
    {
        if (driver == null)
        {
            switch (Properties.browser)
            {
                case Chrome:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (Properties.headless)
                    {
                        chromeOptions.addArguments("--headless");
                    }                    
                    driver = new ChromeDriver(chromeOptions);
                    break;
                    
                case Firefox:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (Properties.headless)
                    {
                        firefoxOptions.addArguments("--headless");                        
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;			             
            }            
        }        
        driver.manage().window().maximize();
        return driver;
    }

    public static void killDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }
}   
