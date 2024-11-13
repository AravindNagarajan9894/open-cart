package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpencartHomePage extends BasePage{
	WebDriver driver;
	public OpencartHomePage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//a[@title='My Account']") WebElement myAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement register;
	@FindBy(xpath="//a[text()='Login']") WebElement login;
	public void clickMyAccount() {
		myAccount.click();
	}
	public void clickRegister() {
		register.click();
	}
	public void clickLogin() {
		login.click();
	}
}
