package com.payu.appiumtest;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidTest extends BaseTest {
	private static AndroidDriver<WebElement> driver;

	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
	}

	@AfterClass
	public void tearDown() {
//		 driver.quit();
	}

	@Test
	public void addToCart() throws InterruptedException {

		AndroidElement skip = (AndroidElement) driver
				.findElement(By.xpath("//android.widget.Button[@text='Skip sign in']"));
		skip.click();

		AndroidElement wait1 = (AndroidElement) new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Search']")));

		AndroidElement search = (AndroidElement) driver
				.findElement(By.xpath("//android.widget.EditText[@text='Search']"));
		search.sendKeys("Echo");

		AndroidElement wait2 = (AndroidElement) new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='echo dot 3rd generation']")));

		AndroidElement findText = (AndroidElement) driver
				.findElement(By.xpath("//android.widget.TextView[@text='echo dot 3rd generation']"));
		findText.click();

		AndroidElement wait3 = (AndroidElement) new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@index='0']")));

		AndroidElement searchedElement = (AndroidElement) driver
				.findElement(By.xpath("//android.widget.TextView[@index='0']"));
		searchedElement.click();

		AndroidElement wait4 = (AndroidElement) new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Use my current location']")));

		AndroidElement location = (AndroidElement) driver
				.findElement(By.xpath("//android.widget.Button[@text='Use my current location']"));
		location.click();

		AndroidElement wait5 = (AndroidElement) new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Allow']")));

		AndroidElement allow = (AndroidElement) driver.findElement(By.xpath("//android.widget.Button[@text='Allow']"));
		allow.click();

		AndroidElement add = ScrollToElement("xpath", "//android.widget.Button[@text='Add to Cart']");
		add.click();

		AndroidElement wait6 = (AndroidElement) new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("in.amazon.mShop.android.shopping:id/action_bar_cart")));

		AndroidElement cart = (AndroidElement) driver
				.findElement(By.id("in.amazon.mShop.android.shopping:id/action_bar_cart"));
		cart.click();
		
		System.out.println("Item Successfully added in Cart");

	}

	public AndroidElement ScrollToElement(String by, String using) {
		AndroidElement element = null;
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width / 2);
		int startPoint = (int) (size.height - 10);
		int endPoint = 10;
		element = (AndroidElement) driver.findElement(by, using);

		while (element.getLocation().getY() > startPoint) {
			new TouchAction(driver).longPress(PointOption.point(anchor, startPoint))
					.moveTo(PointOption.point(anchor, endPoint)).release().perform();
		}
		return element;
	}

}
