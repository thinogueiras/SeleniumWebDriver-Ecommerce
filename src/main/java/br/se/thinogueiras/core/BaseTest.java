package br.se.thinogueiras.core;

import static br.se.thinogueiras.core.DriverFactory.getDriver;
import static br.se.thinogueiras.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest 
{
	@Rule
	public TestName testName = new TestName();	
	
	@After
	public void closeBrowser() throws IOException
	{
		TakesScreenshot takeScreenshot = (TakesScreenshot) getDriver();
		File arquive = takeScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquive, new File("target" + File.separator + "Screenshots" +
				File.separator + testName.getMethodName() + ".jpg"));
		killDriver();
	}
}
