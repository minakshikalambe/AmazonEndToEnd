package amazonProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;

public class logInWithInvalidCredential extends BaseClass{
	@Test( retryAnalyzer = REtryLogic.class )
public void logInWithInvalidCredentialMthod() {

	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/");
	WebElement e1 = driver.findElement(By.id("nav-link-accountList"));
	e1.click();
	WebElement e3 = driver.findElement(By.id("ap_email_login"));
	e3.sendKeys("7028420752");
	WebElement e4 = driver.findElement(By.xpath("//input[@class='a-button-input']"));
	e4.click();
	try {
        WebElement mobileError =
        driver.findElement(By.xpath("//div[@id='intent-confirmation-container']/h1"));
        String errorText = mobileError.getText();
        if (errorText.contains("Looks like you are new to Amazon")) {
            System.out.println("Test Passed: Invalid mobile number detected");
            driver.quit();
            return;
        }
    } catch (NoSuchElementException e) {
        System.out.println("Mobile number is valid, proceeding to password");
    }
	WebElement e8 = driver.findElement(By.id("ap_password"));
	e8.sendKeys("Minakshi@1992");
	WebElement e9 = driver.findElement(By.id("signInSubmit"));
	e9.click();
	WebElement e12 = driver.findElement(By.xpath("//div[@id='auth-error-message-box']/div/div"));
	String text = e12.getText();
	if(text.contains("Your password is incorrect")) {
	    System.out.println("Your password is incorrect");
	} else {
	    System.out.println("user succesfully login");
	
}
}
}
