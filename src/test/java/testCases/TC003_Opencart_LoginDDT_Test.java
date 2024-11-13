package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.OpencartHomePage;
import PageObjects.OpencartLoginPage;
import PageObjects.OpencartMyAccountPage;
import Utilities.DataProviders;

public class TC003_Opencart_LoginDDT_Test extends BaseTestClass {
	
	@Test(dataProvider="LoginTestData" , dataProviderClass=DataProviders.class, groups= {"Master"})
	public void loginDDTTest(String email, String password, String expectedResult) {
		try {
			logger.info("Starting TC002_Opencart_LoginTest");
			//Home Page
			OpencartHomePage hp = new OpencartHomePage(driver);
			logger.info("clicking My Account");
			hp.clickMyAccount();
			logger.info("Clicking Login");
			hp.clickLogin();
			
			//Login Page
			OpencartLoginPage lp = new OpencartLoginPage(driver);
			logger.info("Filling email and Password");
			lp.setEmail(email);
			lp.setPassword(password);
			logger.info("clicking login button");
			lp.clickLogin();
			
			//MyAccount Page
			OpencartMyAccountPage map = new OpencartMyAccountPage(driver);
			logger.info("validating My Account element is displaying");
			
			/*
			 * if(map.verifyMyAccountHeading()) { logger.info("Sucessfully displaying");
			 * map.clickLogout(); Assert.assertTrue(true); } else {
			 * logger.error("My Account element is not displaying");
			 * Assert.assertTrue(false); }
			 */
			boolean ExpectedHeading = map.verifyMyAccountHeading();
			if(expectedResult.equalsIgnoreCase("Valid")) {
				if(ExpectedHeading) {
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else if(!map.verifyMyAccountHeading()) {
					Assert.assertTrue( false);
				}
			}
			if(expectedResult.equalsIgnoreCase("Invalid")){
				if(ExpectedHeading) {
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else if(!map.verifyMyAccountHeading()) {
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e) {
			logger.error("Test case failed");
			Assert.fail();
		}
	}

}
