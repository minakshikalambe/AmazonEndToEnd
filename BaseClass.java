package amazonProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass extends ListernersLogic {

@Parameters("browser")
@BeforeMethod
public void precondition(String nameOfBrowser) {
	if(nameOfBrowser.equalsIgnoreCase("edge"))
	{
		driver = new EdgeDriver();
	}
	if(nameOfBrowser.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/");
}
@AfterMethod
public void afterCondition() {
	driver.quit();
}
}
