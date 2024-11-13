package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.OpencartHomePage;
import PageObjects.OpencartLoginPage;
import PageObjects.OpencartMyAccountPage;

public class TC002_Opencart_Login_Test extends BaseTestClass{
	@Test(groups= {"Master","Sanity"})
	public void loginTest() {
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
			lp.setEmail(property.getProperty("email"));
			lp.setPassword(property.getProperty("password"));
			logger.info("clicking login button");
			lp.clickLogin();
			
			//MyAccount Page
			OpencartMyAccountPage map = new OpencartMyAccountPage(driver);
			logger.info("validating My Account element is displaying");
			if(map.verifyMyAccountHeading()) {
				logger.info("Sucessfully displaying");
				Assert.assertTrue(true);
			}
			else {
				logger.error("My Account element is not displaying");
				Assert.assertTrue(false);
				}
			}
		catch(Exception e){
				Assert.fail();
		}
	}
}
	
	