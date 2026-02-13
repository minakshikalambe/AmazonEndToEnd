package amazonProject;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
public class checkOutProduct extends BaseClass {
	@Test( retryAnalyzer = REtryLogic.class )
public void checkOutProductMethod() throws InterruptedException {
	//@name='proceedToRetailCheckout'
//	EdgeDriver driver = new EdgeDriver();
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
	WebElement proccedToBuyButton = driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
	proccedToBuyButton.click();
	WebElement emailIdEnter = driver.findElement(By.id("ap_email_login"));
	emailIdEnter.sendKeys("7028420754");
	WebElement continueButton = driver.findElement(By.className("a-button-input"));
	continueButton.click();
	WebElement passwordEnter = driver.findElement(By.id("ap_password"));
	passwordEnter.sendKeys("Minakshi@1996");
	WebElement sigininButton = driver.findElement(By.id("signInSubmit"));
	sigininButton.click();
	WebElement addAddressButton = driver.findElement(By.linkText("Add a new delivery address"));
	addAddressButton.click();
	WebElement addFullName = driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));
	addFullName.sendKeys("Minakshi Kalambe");
	WebElement addPhoneNumber = driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));
	addPhoneNumber.sendKeys("7028420754");
	WebElement addPinCode = driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode"));
	addPinCode.sendKeys("440024");
	WebElement addHomeAddress = driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));
	addHomeAddress.sendKeys("Plot no-12, Mahalaxmi Nagar-03");
	WebElement addStreet = driver.findElement(By.id("address-ui-widgets-enterAddressLine2"));
	addStreet.sendKeys("Manewada");
	WebElement addLandMark = driver.findElement(By.id("address-ui-widgets-landmark"));
	addLandMark.sendKeys("Hanuman Mandir");
	WebElement addCity = driver.findElement(By.id("address-ui-widgets-enterAddressCity"));
	 addCity.sendKeys("Nagpur");
	List<WebElement> states = driver.findElements(
	        By.xpath("//ul[@role='listbox']//a[@class='a-dropdown-link']")
	);

	for (WebElement state : states) {
	    if (state.getText().equalsIgnoreCase("MAHARASHTRA")) {
	        state.click();
	        break;
	    }
	}
	WebElement useThisAddressButton = driver.findElement(By.xpath("//input[@data-testid='bottom-continue-button']"));
	useThisAddressButton.click();
	WebElement paymentMode = driver.findElement(By.xpath("//input[@id='pp-CuocDU-151']"));
	paymentMode.click();
	WebElement delivertoThisButton = driver.findElement(By.xpath("//input[@data-csa-c-slot-id='checkout-secondary-continue-shipaddressselect']"));
	delivertoThisButton.click();
	WebElement placeYourOrderButton = driver.findElement(By.id("placeOrder"));
	placeYourOrderButton.click();
	
}
}
