package tests.real;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

import com.codeborne.selenide.Configuration;
import drivers.RealMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class RealTestBase {

  @BeforeAll
  public static void setup() {
    addListener("AllureSelenide", new AllureSelenide());

    Configuration.browser = RealMobileDriver.class.getName();
    Configuration.startMaximized = false;
    Configuration.browserSize = null;
    Configuration.timeout = 10000;
  }

  @BeforeEach
  public void startDriver() {
    open();
  }

  @AfterEach
  public void afterEach() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();

    closeWebDriver();
  }
}
