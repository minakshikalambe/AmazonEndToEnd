package amazonProject;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import assignmentSelenium.screenShot;

public class ListernersLogic implements ITestListener {
	public static WebDriver driver;
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		TakesScreenshot ts=  (TakesScreenshot) driver;//step 1
	    File source= ts.getScreenshotAs(OutputType.FILE);//step 2
	    File destination=new File("C:\\Users\\HP\\eclipse-workspace\\core\\Screenshot\\Pass\\"+new screenShot().getClass() +Math.random()+"passCase.png");
	    try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Screen shot taken-pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		TakesScreenshot ts=                (TakesScreenshot) driver;//step 1
	    File source=         ts.getScreenshotAs(OutputType.FILE);//step 2
	    File destination=new File("C:\\Users\\HP\\eclipse-workspace\\core\\Screenshot\\Fail\\"+new screenShot().getClass() +Math.random()+"failCase.png");
	    try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Screen shot taken-fail");
	}

}
