package drivers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EmulatorMobileDriver implements WebDriverProvider {

  public static final EmulatorConfig emulatorConfig =
      ConfigFactory.create(EmulatorConfig.class, System.getProperties());

  public static URL getAppiumServerUrl() {
    try {
      return new URL(emulatorConfig.hubUrl());
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

    desiredCapabilities.setCapability("platformName", emulatorConfig.platformName());
    desiredCapabilities.setCapability("deviceName", emulatorConfig.deviceName());
    desiredCapabilities.setCapability("version", emulatorConfig.version());
    desiredCapabilities.setCapability("locale", emulatorConfig.locale());
    desiredCapabilities.setCapability("language", emulatorConfig.language());
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
