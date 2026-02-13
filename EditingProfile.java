package amazonProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditingProfile extends BaseClass {
	@Test( retryAnalyzer = REtryLogic.class )
public void editingProfileMethod() throws InterruptedException {
//	ChromeDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://www.amazon.in/");
	WebElement e1 = driver.findElement(By.id("nav-link-accountList"));
	e1.click();
	WebElement e2 = driver.findElement(By.id("ap_email_login"));
	e2.sendKeys("7028420754");
	WebElement e3 = driver.findElement(By.xpath("//input[@class='a-button-input']"));
	e3.click();
	WebElement e4 = driver.findElement(By.id("ap_password"));
	e4.sendKeys("Minakshi@1996");
	WebElement e5 = driver.findElement(By.id("signInSubmit"));
	e5.click();
	WebElement e6 = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	String text = e6.getText();
	if(text.contains("minakshi10")) {
	    System.out.println("Test Passed: User succesfully login");
	} else {
	    System.out.println("Test Failed: User succesfully not login");
	}
	WebElement e7 = driver.findElement(By.id("nav-link-accountList"));
	Actions action = new Actions(driver);
	action.moveToElement(e7).perform();
	WebElement e8 = driver.findElement(By.xpath("//button[@data-testid='switch-accounts-button']"));
	e8.click();
	WebElement e9 = driver.findElement(By.linkText("View"));
	e9.click();
	WebElement e10 = driver.findElement(By.xpath("//button[@class='edit-pencil-icon-button']"));
	e10.click();
	//avatar
	Thread.sleep(2000);
	WebElement e13 = driver.findElement(By.xpath("//input[@id='profile-preferences-avatar-upload-id']"));
	e13.sendKeys("C:\\Users\\HP\\Pictures\\images.jpg");
	Thread.sleep(4000);
	WebElement e11 = driver.findElement(By.id("editProfileNameInputId"));
	e11.sendKeys("minakshikalambe");
	WebElement e12 = driver.findElement(By.xpath("//input[@aria-labelledby='editProfileContinueButton-announce']"));
	e12.click();
}
}
