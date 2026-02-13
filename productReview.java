package amazonProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class productReview extends BaseClass {
	@Test( retryAnalyzer = REtryLogic.class )
public void productReviewMethod() throws InterruptedException {
//	ChromeDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://www.amazon.in/");
	WebElement e1 = driver.findElement(By.id("nav-link-accountList"));
	e1.click();
	WebElement e3 = driver.findElement(By.id("ap_email_login"));
	e3.sendKeys("minakshikalambe10@gmail.com");
	WebElement e4 = driver.findElement(By.xpath("//input[@class='a-button-input']"));
	e4.click();
	WebElement e8 = driver.findElement(By.id("ap_password"));
	e8.sendKeys("Minakshi@1996");
	WebElement e9 = driver.findElement(By.id("signInSubmit"));
	e9.click();
	WebElement orderButton = driver.findElement(By.id("nav-orders"));
	orderButton.click();
	WebElement yearButton = driver.findElement(By.id("a-autoid-1-announce"));
	yearButton.click();
	WebElement year2025 = driver.findElement(By.xpath("//a[normalize-space()='2025']"));
	year2025.click();
	WebElement reviewGivigButton = driver.findElement(By.xpath("//a[@id='a-autoid-5-announce']"));
	reviewGivigButton.click();
	WebElement rattingButton = driver.findElement(By.xpath("(//div[@class='in-context-ryp__form-field--starRating-wrapper']/div/span)[5]"));
	rattingButton.click();
	WebElement submitButton = driver.findElement(By.xpath("//input[@class='a-button-input']"));
	submitButton.click();

}
}
