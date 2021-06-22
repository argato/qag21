package drivers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.WebDriverProvider;
import config.RealConfig;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RealMobileDriver implements WebDriverProvider {

  public static final RealConfig realConfig =
      ConfigFactory.create(RealConfig.class, System.getProperties());

  public static URL getAppiumServerUrl() {
    try {
      return new URL(realConfig.hubUrl());
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
    desiredCapabilities.setCapability("platformName", realConfig.platformName());
    desiredCapabilities.setCapability("deviceName", realConfig.deviceName());
    desiredCapabilities.setCapability("version", realConfig.version());
    desiredCapabilities.setCapability("locale", realConfig.locale());
    desiredCapabilities.setCapability("language", realConfig.language());
    desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
    desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
    desiredCapabilities.setCapability("app", getAbsolutePath(
        "src/test/resources/app-alpha-universal-release.apk"));

    return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
  }

  private String getAbsolutePath(String filePath) {
    File file = new File(filePath);
    assertTrue(file.exists(), filePath + " not found");

    return file.getAbsolutePath();
  }
}
