package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BasicTest {
protected WebDriver driver; 
protected WebDriverWait wait;

protected String baseUrl = "https://www.google.rs/"; 
// driver.navigate().to(baseUrl); 
@BeforeClass
public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

	this.driver = new ChromeDriver();
	this.wait = new WebDriverWait(driver, 30);
	this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.navigate().to("https://plyr.io/");
}

	
@Test(priority=0)
public void TestAudio() { 
	


}
@AfterMethod
public void afterTest(ITestResult result) throws IOException {
	if (result.getStatus() == ITestResult.FAILURE) {
		File ss= ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE); 
		String fileName= new SimpleDateFormat("yyyy-MM-dd-HH-mm'.png'").format(new Date()); 
		File save = new File ("screenshots/" +fileName); 
		FileHandler.copy(ss, save);
	}
}

@AfterClass
public void afterClass() { 
	this.driver.close();
}

}
