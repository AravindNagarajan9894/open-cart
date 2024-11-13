package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.OpencartHomePage;
import PageObjects.OpencartRegisterationPage;

public class Tc001_Opencart_Registration_Test extends BaseTestClass {
	@Test(groups= {"Sanity"})
	public void registrationTest() {
		try {
			logger.info("Staring Testcase Tc001_Opencart_Registration_Test ");
			OpencartHomePage hp = new OpencartHomePage(driver);
			logger.info("Clcking Register");
			hp.clickMyAccount();
			hp.clickRegister();
			
			logger.info("Filling the forms");
			OpencartRegisterationPage rp = new OpencartRegisterationPage(driver);
			rp.setFname(randomString());
			rp.setLname(randomString());
			rp.setEmail(randomString()+"@Yahoo.com");
			rp.setPhoneNumber(randomNumber() );
			String password = randomPassword();
			rp.setPassword(password);
			rp.setCnfPassword(password);
			rp.clkAgree();
			rp.clickContinue();
			String resultText = rp.getCnfText();
			logger.info("getting result text!!!");
			if(resultText.equals("Your Account Has Been Created!"))
			{
				logger.info("SucessFully matched");
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e) {
		
			Assert.fail();
		}
		logger.info("Test case Finished");
	}
}
