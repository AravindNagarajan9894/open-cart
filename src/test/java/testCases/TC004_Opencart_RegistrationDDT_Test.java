package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.OpencartHomePage;
import PageObjects.OpencartMyAccountPage;
import PageObjects.OpencartRegisterationPage;
import Utilities.DataProviders;

public class TC004_Opencart_RegistrationDDT_Test extends BaseTestClass {
	@Test
	(dataProvider= ("RegisterationTestData"), dataProviderClass=DataProviders.class, groups= {"Sanity"})
	public void resgistrationDDTTest(String fName, String lName, String email, String tele , String pass, String cnfPass, String exceptedResult) {
		try {
			logger.info("Staring Testcase TC004_Opencart_RegistrationDDT_Test ");
			OpencartHomePage hp = new OpencartHomePage(driver);
			logger.info("Clcking Register");
			hp.clickMyAccount();
			hp.clickRegister();
			
			logger.info("Filling the forms");
			OpencartRegisterationPage rp = new OpencartRegisterationPage(driver);
			rp.setFname(fName);
			rp.setLname(lName);
			rp.setEmail(email);
			rp.setPhoneNumber(tele);
			//String password = randomPassword();
			rp.setPassword(pass);
			rp.setCnfPassword(cnfPass);
			rp.clkAgree();
			rp.clickContinue();
			String resultUrl = rp.getCnfText();
			String ExpectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/success";
			logger.info("getting result text!!!");
			/*
			 * if(resultText.equals("Your Account Has Been Created!")) {
			 * logger.info("SucessFully matched"); Assert.assertTrue(true); } 
			 * else {
			 * logger.error("Test failed"); logger.debug("Debug logs");
			 * Assert.assertTrue(false); }
			 */
			OpencartMyAccountPage map = new OpencartMyAccountPage(driver);
			Thread.sleep(1000);
	
			if(exceptedResult.equalsIgnoreCase("valid")) {
				if(ExpectedUrl.equals(resultUrl)) {
					map.clickLogout();
					logger.info("test case passed");
					Assert.assertTrue(true);
				}
				else {
					logger.info("test case failed");
					Assert.assertTrue(false);
				}
			}
			else if(exceptedResult.equalsIgnoreCase("Invalid")) {
				if(ExpectedUrl.equals(resultUrl)) {
					logger.info("test case failed");
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else{
					logger.info("test case passed");
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e) {
			logger.info("test case didn't executed!!!");
			Assert.fail();
		}
	}
}
