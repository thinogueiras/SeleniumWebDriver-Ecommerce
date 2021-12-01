package br.se.thinogueiras.tests;

import static br.se.thinogueiras.pages.ProductBuyPage.accessLoginPage;
import static br.se.thinogueiras.pages.ProductBuyPage.accessPage;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.se.thinogueiras.core.BaseTest;
import br.se.thinogueiras.pages.ProductBuyPage;

public class ProductBuyTest extends BaseTest
{
	private static ProductBuyPage page = new ProductBuyPage();
	
	@Before
	public void setUp()
	{
		accessPage();	
	}
	
	@Test
	public void buyProduct()
	{
		accessLoginPage();
		page.setEmailAddress("teste2021@teste.com");
		page.setPassword("teste@123");
		page.clickOnSignInButton();
		page.clickOnTshirtsMenu();
		page.clickOnProductFadedShort();
		page.clickOnAddToCartButton();
		page.clickOnContinueShoppingButton();
		page.clickOnDressesMenu();
		page.clickOnProductPrintedDress();
		page.clickOnAddToCartButton();
		page.clickOnProceedToCheckoutButton1();
		page.clickOnProceedToCheckoutButton2();
		page.clickOnProceedToCheckoutButton3();
		page.clickOnTermsOfService();
		page.clickOnProceedToCheckoutButton4();
		page.clickOnPayByBankWire();
		page.clickOnConfirmMyOrder();
		assertEquals("Your order on My Store is complete.", page.checkOrderMessage());		
	}
}
