package amazonProject;


import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.dataloader.impl.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.asserts.Assertion;
@Listeners(ListernersLogic.class)
public class logInWithCoorectCredentials extends BaseClass {
	@Test(retryAnalyzer = REtryLogic.class )
public void loginMethod() throws InterruptedException {
//	ChromeDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	Reporter.log("browser is launched and maximised");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://www.amazon.in/")
	Reporter.log("amazon");
	WebElement e1 = driver.findElement(By.id("nav-link-accountList"));
	e1.click();
	WebElement e3 = driver.findElement(By.id("ap_email_login"));
	e3.sendKeys("7028420754");
	WebElement e4 = driver.findElement(By.xpath("//input[@class='a-button-input']"));
	e4.click();
	WebElement e8 = driver.findElement(By.id("ap_password"));
	e8.sendKeys("Minakshi@1996");
	WebElement e9 = driver.findElement(By.id("signInSubmit"));
	e9.click();
	Reporter.log("login done");
	WebElement e12 = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	String text = e12.getText();
	if(text.contains("minakshi10")) {
	    System.out.println("Test Passed: User succesfully login");
	} else {
	    System.out.println("Test Failed: User succesfully not login");
	}
	Thread.sleep(200);
	String PageTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	//Assert.assertEquals(driver.getTitle(), PageTitle,"login fails");
	Assertion a1= new Assertion();
	a1.assertEquals(driver.getTitle(), PageTitle,"login fails");
	//a1.assertTrue(e3.isDisplayed(),"not displayeed");
	Reporter.log("assertion pass");
	WebElement e13 = driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_youraccount_btn']"));
	Actions action = new Actions(driver);
	action.moveToElement(e13);
//	WebElement e14 = driver.findElement(By.id("nav-item-signout"));
//	e14.click();
	//WebElement e16 = driver.findElement(By.xpath("//h1[@class='a-size-medium-plus a-spacing-small']"));
//	Assert.assertEquals(e16.getText(), "Sign in or create account","login fails");
	
}
}
