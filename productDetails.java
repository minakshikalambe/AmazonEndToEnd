package amazonProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class productDetails extends BaseClass {
	@Test( retryAnalyzer = REtryLogic.class )
public void productDeatilsMethod() throws InterruptedException {
//	ChromeDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://www.amazon.in/");
	WebElement e1 = driver.findElement(By.id("twotabsearchtextbox"));
	e1.sendKeys("horror book"+Keys.ENTER);
	Thread.sleep(2000);
	WebElement fristProduct = driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]"));
	fristProduct.click();
	Thread.sleep(2000);
	Set<String> parentchildid=driver.getWindowHandles();
	Iterator<String> itr = parentchildid.iterator();
	String parentWindow = itr.next();   // first window (parent)
	String childWindow = itr.next();    // second window (child)
	driver.switchTo().window(childWindow);
	//findPrize
	WebElement prizeFind = driver.findElement(By.xpath("(((//div[@class='a-section a-spacing-none aok-align-center aok-relative']/span)[3]/span)[2]/span)[2]"));
	if (!prizeFind.getText().isEmpty()) {
		int price = Integer.parseInt(prizeFind.getText());
	    System.out.println("Price is present: " + price);
	} else {
	    System.out.println("Price is NOT present");
	}
	//find Description of product
	WebElement productDescription = driver.findElement(By.xpath("//div[@id='bookDescription_feature_div']"));
	String descriptionText = productDescription.getText();
	
	if (!descriptionText.trim().isEmpty()) {
	    System.out.println("Product description is present");
	} else {
	    System.out.println("Product description is NOT present");
	}
	//find review of product
	WebElement productReview = driver.findElement(By.id("customerReviews"));
	String reviewText = productReview.getText();
	if (!reviewText.trim().isEmpty()) {
	    System.out.println("Product description is present");
	} else {
	    System.out.println("Product description is NOT present");
	}
}
}
