package drivers;


import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserstackMobileDriver implements WebDriverProvider {

  public static final BrowserstackConfig browserstackConfig =
      ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

  public static URL getBrowserstackUrl() {
    try {
      return new URL(browserstackConfig.hubUrl());
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
    desiredCapabilities.setCapability("browserstack.user", browserstackConfig.username());
    desiredCapabilities.setCapability("browserstack.key", browserstackConfig.key());

    // Set URL of the application under test
    desiredCapabilities.setCapability("app", browserstackConfig.appUrl());

    // Specify device and os_version for testing
    desiredCapabilities.setCapability("device", browserstackConfig.device());
    desiredCapabilities.setCapability("os_version", browserstackConfig.os());

    // Set other BrowserStack capabilities
    desiredCapabilities.setCapability("project", "First Project");

    desiredCapabilities.setCapability("build", "Android Build");
    desiredCapabilities.setCapability("name", "Second_test_wiki");
    return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);

  }
}
