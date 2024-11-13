package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpencartLoginPage extends BasePage{
	WebDriver driver;
	public OpencartLoginPage(WebDriver driver){
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login;
	
	public void setEmail(String email){
		txt_email.sendKeys(email);
	}
	public void setPassword(String pass){
		txt_password.sendKeys(pass);
	}
	public void clickLogin(){
		btn_login.click();
	}
}
