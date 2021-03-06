package io.appium.java_client.ios;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.util.List;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Test context-related features
 */
public class IOSAccessibilityIdTest {

  private AppiumDriver<?> driver;
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
    File app = new File(appDir, "UICatalog.app.zip");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    driver = new IOSDriver<WebElement>(service.getUrl(), capabilities);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

  @Test
  public void findElementTest() {
    WebElement element = driver.findElementByAccessibilityId("UICatalog");
    assertNotNull(element);
  }

  @Test
  public void findElementsTest() {
    List<? extends WebElement> elements = driver.findElementsByAccessibilityId("UICatalog");
    assertTrue(elements.size() > 0);
  }

  @Test
  public void MobileElementByTest() {
    WebElement element = driver.findElement(MobileBy.AccessibilityId("UICatalog"));
    assertNotNull(element);
  }

  @Test
  public void MobileElementsByTest() {
    List<? extends WebElement> elements = driver.findElements(MobileBy.AccessibilityId("UICatalog"));
    assertTrue(elements.size() > 0);
  }

  @AfterClass
  public static void afterClass(){
    if (service != null)
      service.stop();
  }
}
