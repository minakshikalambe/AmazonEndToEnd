package amazonProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkCart extends BaseClass {
	@Test( retryAnalyzer = REtryLogic.class )
public void checkCartMethod() throws InterruptedException {
//	ChromeDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://www.amazon.in/");
	WebElement e1 = driver.findElement(By.id("twotabsearchtextbox"));
	e1.sendKeys("horror book"+Keys.ENTER);
	Thread.sleep(2000);
	WebElement productTitleElement = driver.findElement(By.xpath("(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal'])[1]"));
	String productTitle = productTitleElement.getText();
	System.out.println("productTitle"+productTitle);
	WebElement addToCartElement = driver.findElement(By.xpath("(//button[@aria-label='Add to cart'])[1]"));
	addToCartElement.click();
	Thread.sleep(2000);
	WebElement navToCartButton = driver.findElement(By.id("nav-cart"));
	navToCartButton.click();
	
	Thread.sleep(2000);
    WebElement cartProductTitleElement = driver.findElement(
            By.xpath("(//span[@class='a-truncate-cut'])[1]")
    );
    String cartProductTitle = cartProductTitleElement.getText();
    System.out.println("Cart Product Title: " + cartProductTitle);
    Assert.assertEquals(productTitle.contains(cartProductTitle), true,"not navigated");
    if (productTitle.contains(cartProductTitle) || cartProductTitle.contains(productTitle)) {
        System.out.println("Correct product added to cart");
    } else {
        System.out.println("Wrong product added to cart");
    }
    WebElement countOfOneProduct = driver.findElement(By.xpath("//span[@data-a-selector='value']"));
    countOfOneProduct.getText();
    System.out.println(countOfOneProduct.getText());
    int initialCount = Integer.parseInt(countOfOneProduct.getText().trim());
    //quantity updation
    WebElement incrementElement = driver.findElement(By.xpath("//button[@aria-label='Increase quantity by one']"));
    incrementElement.click();
    Thread.sleep(2000); 
    WebElement updatedCountOfProduct = driver.findElement(
            By.xpath("//span[@data-a-selector='value']")
    );
    int updatedCount = Integer.parseInt(updatedCountOfProduct.getText().trim());

    if (updatedCount == initialCount + 1) {
        System.out.println("Quantity increased by 1");
    } else {
        System.out.println("Quantity did NOT increase correctly");
    }
    if(updatedCount>1) {
    WebElement decrementElement = driver.findElement(By.xpath("//button[@data-a-selector='decrement']"));
    decrementElement.click();
    Thread.sleep(2000);
    WebElement finalCountElement = driver.findElement(
            By.xpath("//span[@data-a-selector='value']")
    );
    int finalCount = Integer.parseInt(finalCountElement.getText().trim());
    System.out.println("Quantity after decrement: " + finalCount);
    if (finalCount == updatedCount - 1) {
        System.out.println("Quantity decreased by 1");
    } else {
        System.out.println("Quantity did NOT decrease correctly");
    }
    }
    Thread.sleep(2000);
    WebElement finalCountDecrementElement = driver.findElement(
            By.xpath("//span[@data-a-selector='value']")
    );
    //deletation of product from cart
    int finalCountDecrement = Integer.parseInt(finalCountDecrementElement.getText().trim());
    if (finalCountDecrement == 1) {
        System.out.println("Quantity is 1");
        WebElement decrementElement = driver.findElement(
                By.xpath("//button[@data-a-selector='decrement']")
        );
        decrementElement.click();
        Thread.sleep(2000);
        boolean isProductPresent  = driver.findElements(
                By.xpath("(//span[@class='a-truncate-cut'])[1]")
        ).size() > 0;;

        if (isProductPresent) {
            System.out.println("Product is removed from cart");
        } else {
            System.out.println("Product is not removed from cart");
        }
        
    }
}
}
