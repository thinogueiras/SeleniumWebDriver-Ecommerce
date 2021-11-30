package br.se.thinogueiras.pages;

import static br.se.thinogueiras.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import br.se.thinogueiras.core.BasePage;
import br.se.thinogueiras.core.Browser;

public class CustomerRegistrationPage extends BasePage 
{
	static Faker faker = new Faker();
	private static WebDriverWait wait;
	private static WebElement element;
	
	public static void accessLoginPage()
	{
		getDriver(Browser.Chrome, false).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	public void setNewEmailAccount()
	{		
		sendText("email_create", faker.internet().emailAddress());
	}
	
	public void setNewEmailAccount(String text)
	{		
		sendText("email_create", text);
	}
	
	public static void clickOnCreateAnAccountButton()
	{
		clickByXpath("//*[@id=\"SubmitCreate\"]/span");
	}
	
	public String validateScreenTitleCreateAnAccount(String textCheck)
	{
		return getScreenTitle("//*[@id=\"columns\"]/div[3]", textCheck);
	}
	
	public static void setMaleGender()
	{
		clickRadioButton("id_gender1");
	}
	
	public void setFemaleGender()
	{
		clickRadioButton("id_gender2");
	}
	
	public void setFirstName(String firstName)
	{		
		sendText("customer_firstname", firstName);;
	}
	
	public void setLastName(String lastName)
	{
		sendText("customer_lastname", lastName);
	}
	
	public static void setPassword(String password)
	{
		sendText("passwd", password);
	}	
	
	public static void selectBirthDate(String birthDate)
	{
		int day = Integer.parseInt(birthDate.substring(0, 2));
		int month = Integer.parseInt(birthDate.substring(2, 4));
		int year = Integer.parseInt(birthDate.substring(4));		
		selectComboField("days", day);		
		selectComboField("months", month);
		selectComboFieldYear("years", year);		
	}
	
	public static void clickCheckBoxNewsletter()
	{
		clickById("newsletter");
	}
	
	public static void clickCheckBoxSpecialOffersFromPartners()
	{
		clickById("optin");
	}		 
	
	public static void setCompanyName(String companyName)
	{
		sendText("company", companyName);
	}
	
	public static void setAddress(String address)
	{
		sendText("address1", address);
	}
	
	public static void setCity(String city)
	{
		sendText("city", city);
	}
	
	public static void setState(String text)
	{
		selectComboField("id_state", text);
	}
	
	public void setZipPostalCode(String text)
	{
		sendText("postcode", text);
	}
	
	public void setCountry(String country)
	{
		selectComboField("id_country", country);		
	}
	
	public void setAdditionalInformation(String text)
	{
		sendText("other", text);
	}
	
	public void setMobileNumber(String text)
	{
		sendText("phone_mobile", text);
	}
	
	public static void setAddressAlias(String text)
	{
		clearField("alias");
		sendText("alias", text);
	}
	
	public static void clickRegisterButton()
	{
		clickByXpath("//*[@id=\"submitAccount\"]/span");
	}
	
	public String checkSuccessfulyRegister()
	{
		return getElementText("//*[@id=\"center_column\"]/p");
	}
	
	public String checkCustomerExists() 
	{
		return getElementText("//*[@id=\"create_account_error\"]/ol/li");
	}
	
	public static void setEmailAddress(String email)
	{
		sendText("email", email);
	}	
	
	public static void clickOnSignInButton()
	{
		clickByXpath("//*[@id=\"SubmitLogin\"]/span");
	}
	
	public void signIn(String email, String password)
	{
		setEmailAddress(email);
		setPassword(password);
		clickOnSignInButton();
	}
	
	public static void clickOnMyPersonalInformationButton()
	{
		wait = new WebDriverWait(getDriver(), 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")));
		element.click();
	}
	
	public String getTextEmailField()
	{
		return getTextFields("email");
	}
	
	public static void completeRegisterCustomer()
	{
		sendText("email", faker.internet().emailAddress());
		clickOnCreateAnAccountButton();		
		setMaleGender();
		sendText("customer_firstname", faker.name().firstName());
		sendText("customer_lastname", faker.name().lastName());
		setPassword("teste@123");
		selectBirthDate("14111989");
		clickCheckBoxNewsletter();
		clickCheckBoxSpecialOffersFromPartners();
		sendText("company", faker.company().name());
		sendText("address1", faker.address().fullAddress());
		sendText("city", faker.address().cityName());
		sendText("id_state", faker.address().state());
		sendText("00000");
		sendText("id_country", faker.address().country());
		sendText("Teste");
		sendText("phone_mobile", faker.phoneNumber().cellPhone());
		setAddressAlias(faker.internet().emailAddress());		
		clickRegisterButton();
	}	
}
