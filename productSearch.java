package amazonProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class productSearch extends BaseClass {
	@Test(dataProvider = "method7", retryAnalyzer = REtryLogic.class )
public void method4(String input) throws InterruptedException {
//	ChromeDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://www.amazon.in/");
	Assertion a1 = new Assertion();
	SoftAssert softA1 = new SoftAssert();
	WebElement e1 = driver.findElement(By.id("twotabsearchtextbox"));
	e1.sendKeys(input +Keys.ENTER);
	WebElement searchText = driver.findElement(
		    By.xpath("//span[@class='a-color-state a-text-bold']"));
		String actualText = searchText.getText();
		System.out.println(actualText);   

		if (actualText.contains("horror book")) {
		    System.out.println("Test Passed: Correct search term displayed");
		} else {
		    System.out.println("Test Failed: Incorrect search term");
		}
		List <WebElement> allProducts = driver.findElements(
			    By.xpath("//div[@class=\"a-section a-spacing-base desktop-grid-content-view\"]"));
		softA1.assertEquals(allProducts.size()>40, false);
		softA1.assertAll();
	    a1.assertEquals(allProducts.size()>40, true);
		Assert.assertEquals(allProducts.size()>40, true );
       
		
}
	
	@DataProvider
	public Object[][] method7(){
		Object d1 [][] = new Object[1][1];
		d1[0][0]="shoes";
		//d1[1][0]="mobile";
		return d1;
	}
}
