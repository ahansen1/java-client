package io.appium.java_client.android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test -android uiautomator locator strategy
 */
public class AndroidUIAutomatorTest {

  private AndroidDriver<AndroidElement> driver;
  private static AppiumDriverLocalService service;

  @BeforeClass
  public static void beforeClass() throws Exception{
     service = AppiumDriverLocalService.buildDefaultService();
     service.start();
  }

  @Before
  public void setup() throws Exception {
    if (service == null || !service.isRunning())
       throw new RuntimeException("An appium server node is not started!");

    File appDir = new File("src/test/java/io/appium/java_client");
    File app = new File(appDir, "ApiDemos-debug.apk");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    driver = new AndroidDriver<AndroidElement>(service.getUrl(), capabilities);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

  @Test
  public void findElementTest() {
    WebElement element = driver.findElementByAndroidUIAutomator("new UiSelector().index(0)");
    assertEquals("android.widget.FrameLayout", element.getTagName());
  }

  @Test
  public void findElementsTest() {
    List<AndroidElement> elements = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
    assertTrue(elements.size() > 10);
  }

  @Test
  public void findElementByTest() {
    AndroidElement element = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().index(0)"));
    assertEquals("android.widget.FrameLayout", element.getTagName());
  }

  @Test
  public void findElementsByTest() {
    List<AndroidElement> elements = driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)"));
    assertTrue(elements.size() > 10);
  }

  @Test
  public void findChainedElementsTest() {
	  AndroidElement el1 = driver.findElementByAndroidUIAutomator("resourceId(\"android:id/content\")");
	  MobileElement el2 = el1.findElement(MobileBy.AndroidUIAutomator("text(\"Accessibility\")"));
	  el2.click();
	  AndroidElement el3 = driver.findElementByAndroidUIAutomator("text(\"Custom View\")");
	  assertTrue(el3.isDisplayed());
  }

  @Test(expected = IllegalArgumentException.class)
  public void ErrorTest() {
    driver.findElementByAndroidUIAutomator(null);
  }


  @AfterClass
  public static void afterClass(){
    if (service != null)
       service.stop();
  }
}