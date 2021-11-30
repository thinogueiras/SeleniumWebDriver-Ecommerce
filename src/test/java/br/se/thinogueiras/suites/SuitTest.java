package br.se.thinogueiras.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.se.thinogueiras.tests.CustomerRegistrationTest;
import br.se.thinogueiras.tests.LoginTest;
import br.se.thinogueiras.tests.ProductBuyTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTest.class, 
	CustomerRegistrationTest.class,
	ProductBuyTest.class})

public class SuitTest 
{

}
