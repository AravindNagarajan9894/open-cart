package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpencartRegisterationPage extends BasePage{
	WebDriver driver;
	public OpencartRegisterationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtPhone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtCnfPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement chkAgree;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//div[@id=\"content\"]/h1") WebElement CnfText;
	
	public void setFname(String fname) {
		txtFname.sendKeys(fname);
	}
	public void setLname(String lname) {
		txtLname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPhoneNumber(String phone) {
		txtPhone.sendKeys(phone);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void setCnfPassword(String cnfpassword) {
		txtCnfPassword.sendKeys(cnfpassword);
	}
	public void clkAgree() {
		chkAgree.click();
	}
	public void clickContinue() {
		btnContinue.click();
	}
	public String getCnfText() {
		try {
		return CnfText.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
}
