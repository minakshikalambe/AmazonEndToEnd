package amazonProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class newRegisteration extends BaseClass {
	@Test( retryAnalyzer = REtryLogic.class )
public void newRegisterationMethod() {
//	ChromeDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://www.amazon.in/");
	WebElement e1 = driver.findElement(By.id("nav-link-accountList"));
	Actions action = new Actions(driver);
	action.moveToElement(e1).perform();
	WebElement e2 = driver.findElement(By.linkText("Start here."));
	e2.click();
	WebElement e3 = driver.findElement(By.id("ap_email_login"));
	e3.sendKeys("minakshi.evdt@gmail.com");
	WebElement e4 = driver.findElement(By.xpath("//input[@class='a-button-input']"));
	e4.click();
	WebElement e5 = driver.findElement(By.xpath("//input[@class='a-button-input']"));
	e5.click();
	WebElement e6 = driver.findElement(By.id("ap_phone_number"));
	e6.sendKeys("7028420754");
	WebElement e7 = driver.findElement(By.id("ap_customer_name"));
	e7.sendKeys("minakshi10");
	WebElement e8 = driver.findElement(By.id("ap_password"));
	e8.sendKeys("Minakshi@1996");
	WebElement e9 = driver.findElement(By.id("continue"));
	e9.click();
	WebElement e10 = driver.findElement(By.id("cvf-input-code"));
	e10.sendKeys("326806");
	WebElement e11 = driver.findElement(By.xpath("//input[@aria-label='Verify OTP Button']"));
	e11.click();
	WebElement e12 = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	String text = e12.getText();

	if(text.contains("minakshi10")) {
	    System.out.println("Test Passed: User succesfully registered");
	} else {
	    System.out.println("Test Failed: User succesfully not registered");
	}
}
}
