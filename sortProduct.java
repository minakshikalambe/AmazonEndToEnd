package amazonProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class sortProduct extends BaseClass{
	@Test( priority = 2, retryAnalyzer = REtryLogic.class )
public  void sortProductMethod() throws InterruptedException {
	
	WebElement e1 = driver.findElement(By.id("twotabsearchtextbox"));
	e1.sendKeys("horror book"+Keys.ENTER);
	Thread.sleep(2000);
	WebElement sortingDropDown = driver.findElement(By.xpath("//select[@name='s']"));
	Select sort = new Select(sortingDropDown);
	// Select option of  Low to High
	sort.selectByVisibleText("Price: Low to High");
	List <WebElement> prizeList = driver.findElements(By.xpath("//div[@data-cy='price-recipe']/div[@class='a-row a-size-base a-color-base']/div//span[@class='a-price-whole']"));

	List<Integer> actualPrices = new ArrayList<>();

	for (WebElement price : prizeList) {
	    String priceText = price.getText();
	    priceText = priceText.replace(",", "");
	    int value = Integer.parseInt(priceText);
	    actualPrices.add(value);
	}

	System.out.println("Prices from UI: " + actualPrices);

	List<Integer> sortedPrices = new ArrayList<>(actualPrices);
	Collections.sort(sortedPrices);

	System.out.println("Expected Sorted Prices: " + sortedPrices);

	if (actualPrices.equals(sortedPrices)) {
	    System.out.println("Prices are sorted from Low to High");
	} else {
	    System.out.println("Prices are NOT sorted from Low to High");
	}

}
}
