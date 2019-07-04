/*
 * package com.payu.appiumtest;
 * 
 * import org.testng.annotations.AfterMethod; import
 * org.testng.annotations.Test; import org.testng.annotations.BeforeMethod;
 * 
 * import io.appium.java_client.android.AndroidDriver; import
 * io.appium.java_client.ios.IOSDriver; import
 * io.appium.java_client.pagefactory.AndroidFindBy; import
 * io.appium.java_client.pagefactory.AppiumFieldDecorator; import
 * io.appium.java_client.pagefactory.iOSFindBy; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.remote.CapabilityType; import
 * org.openqa.selenium.remote.DesiredCapabilities; import
 * org.openqa.selenium.support.PageFactory; import
 * org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
 * 
 * import java.io.File; import java.net.MalformedURLException; import
 * java.net.URL; import java.util.concurrent.TimeUnit;
 * 
 * public class FirstTest {
 * 
 * 
 * protected IOSDriver iosdriver; protected AndroidDriver androiddriver;
 * 
 * 
 * @BeforeMethod protected void prepareAppium() throws MalformedURLException,
 * InterruptedException { AndroidDriver driver;
 * 
 * 
 * File classpathRoot = new File(System.getProperty("user.dir")); File appDir =
 * new File(classpathRoot, "/Apps/Amazon/"); File app = new File(appDir,
 * "in.amazon.mShop.android.shopping.apk");
 * 
 * DesiredCapabilities capabilities = new DesiredCapabilities();
 * capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
 * capabilities.setCapability("deviceName", "Nexus");
 * capabilities.setCapability("platformVersion", "6.0");
 * capabilities.setCapability("platformName", "Android"); //
 * capabilities.setCapability("app", app.getAbsolutePath());
 * capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
 * capabilities.setCapability("appActivity",
 * "com.amazon.mShop.home.HomeActivity");
 * 
 * driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),
 * capabilities); driver.manage().timeouts().implicitlyWait(80,
 * TimeUnit.SECONDS); Thread.sleep(10000);
 * 
 * 
 * 
 * }
 * 
 * @AfterMethod public void tearDown() {
 * 
 * androiddriver.quit(); }
 * 
 * }
 * 
 * 
 */