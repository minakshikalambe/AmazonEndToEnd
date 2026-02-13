package amazonProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class filterProduct extends BaseClass {
	@Test( priority = 1, retryAnalyzer = REtryLogic.class )
public void filterProductMethod() throws InterruptedException {
//	ChromeDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://www.amazon.in/");
	WebElement e1 = driver.findElement(By.id("twotabsearchtextbox"));
	e1.sendKeys("horror book"+Keys.ENTER);
	Thread.sleep(4000);
	//check for prize
	WebElement priceFilter = driver.findElement(By.xpath("//li[@id='p_36/dynamic-picker-2']/span/a"));
	priceFilter.click();
	WebElement priceFilterText = driver.findElement(By.xpath("//li[@id='p_36/dynamic-picker-2']/span/a/span"));
	System.out.println(priceFilterText.getText());
	String prize = priceFilterText.getText();
	prize = prize.replace("₹", "").replace(" ", "");
	// Split using hyphen
	String[] prices = prize.split("-");
	// Convert to int
	int minPrice = Integer.parseInt(prices[0]);
	int maxPrice = Integer.parseInt(prices[1]);
	List <WebElement> prizeList = driver.findElements(By.xpath("//div[@data-cy='price-recipe']/div[@class='a-row a-size-base a-color-base']/div//span[@class='a-price-whole']"));
	for (WebElement price : prizeList) {
		String priceText = price.getText();
		int actualPrice = Integer.parseInt(priceText);

		if (actualPrice >= minPrice && actualPrice <= maxPrice) {
			System.out.println("PASS : ₹" + actualPrice);
		} else {
			System.out.println("FAIL : ₹" + actualPrice);
		}
	}	
	//check for format
	WebElement formatFilter = driver.findElement(By.xpath("//li[@id='p_n_binding_browse-bin/1318376031']//a"));
	formatFilter.click();
	WebElement formatFilterText = driver.findElement(By.xpath("//li[@id='p_n_binding_browse-bin/1318376031']//a/span"));
	String fromatSearchText = formatFilterText.getText();
	Thread.sleep(2000);
	List <WebElement> formatList = driver.findElements(By.xpath("//div[@data-cy='price-recipe']/div[@class='a-row a-spacing-mini a-size-base a-color-base']/a"));
	System.out.println(formatList.size());
	Thread.sleep(2000);
	for(WebElement format : formatList)
	{
		if(fromatSearchText.equalsIgnoreCase(format.getText()))
		{
			System.out.println("Pass : filter woking according to click" + fromatSearchText);
		}
		else
		{
			System.out.println("fail : filter not woking according to click" + fromatSearchText);
		}
	}
}
}
