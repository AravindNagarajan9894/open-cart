package testCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
public class BaseTestClass {
public WebDriver driver;
public Logger logger;
public Properties property;
	
	@BeforeClass(groups={"Sanity"})
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException {
	    
	    FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
	    property = new Properties();
	    property.load(file);
	    logger = LogManager.getLogger(this.getClass());
	    logger.info("setting up browser and the broswer is :"+ browser);
	    switch(browser) {
	    case "chrome" : driver= new ChromeDriver(); break;
	    case "edge"   : driver= new EdgeDriver(); break;
	    case "firefox": driver = new FirefoxDriver();break;
	    default : System.out.println("Invalid browser"); return;
	    }
		
		driver.get(property.getProperty("NinjaUrl"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	@AfterClass(groups={"Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(6);
	}
	public String randomNumber() {
		return RandomStringUtils.randomAlphanumeric(10);
	}
	public String randomPassword() {
		String randomString = RandomStringUtils.randomAlphabetic(3);
		String randomNumbers = RandomStringUtils.randomAlphanumeric(3);
		return (randomString+"@"+randomNumbers);
	}
	public String captureScreenshot(String screenshotName) {
		Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = formatter.format(date);
        
        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        String targetFileLocation = ".\\screenshots\\"+screenshotName+"_"+formattedDate+".png";
        File targetFile = new File(targetFileLocation);
        sourceFile.renameTo(targetFile);
		return targetFileLocation;
	}
}
