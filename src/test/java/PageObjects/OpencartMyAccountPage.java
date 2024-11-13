package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpencartMyAccountPage extends BasePage{
	
	WebDriver driver;
	public OpencartMyAccountPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement myAccountHeading;
	@FindBy(xpath="(//a[text()='Logout'])[2]") WebElement logout;
	@FindBy(xpath="//a[text()='Continue']") WebElement btn_continue;
	
	public boolean verifyMyAccountHeading() {
		try {
			return (myAccountHeading.isDisplayed());
		}
		catch(Exception e) {
			
			return false;
		}
	}
	public void clickLogout() {
		logout.click();
		btn_continue.click();
	}
}
