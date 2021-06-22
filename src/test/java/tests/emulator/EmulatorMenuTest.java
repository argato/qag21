package tests.emulator;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

@Tag("selenide_android")
public class EmulatorMenuTest extends EmulatorTestBase {

  @Test
  @DisplayName("Check texts menu")
  void searchTest() {
    back();

    step("Click Explore", () -> {
      $(MobileBy.AccessibilityId("Explore")).click();
    });
    step("Verify header text", () ->
        $$(MobileBy.id("org.wikipedia.alpha:id/view_announcement_text"))
            .shouldHave(texts(
                "Customize your Explore feed You can now choose what to show on your feed, and also prioritize your favorite types of content.")));

    step("Click Saved", () -> {
      $(MobileBy.AccessibilityId("Saved")).click();
    });
    step("Verify header text", () ->
        $$(MobileBy.id("org.wikipedia.alpha:id/messageTitleView"))
            .shouldHave(texts("Sync reading lists")));

    step("Click Edits", () -> {
      $(MobileBy.AccessibilityId("Edits")).click();
    });
    step("Verify header text", () ->
        $$(MobileBy.id("org.wikipedia.alpha:id/positiveButton"))
            .shouldHave(texts("LOG IN / JOIN WIKIPEDIA")));

    step("Click More", () -> {
      $(MobileBy.AccessibilityId("More")).click();
    });
    step("Verify header text", () ->
        $$(MobileBy.id("org.wikipedia.alpha:id/main_drawer_login_button"))
            .shouldHave(texts("LOG IN / JOIN WIKIPEDIA")));
    step("Verify item History text", () -> {
      $$(MobileBy.id("org.wikipedia.alpha:id/main_drawer_history_container"))
          .first()
          .$(By.className("android.widget.TextView"))
          .shouldHave(Condition.text("History"));
    });
    step("Verify item Settings text", () -> {
      $$(MobileBy.id("org.wikipedia.alpha:id/main_drawer_settings_container"))
          .first()
          .$(By.className("android.widget.TextView"))
          .shouldHave(Condition.text("Settings"));
    });
    step("Verify item Donate text", () -> {
      $$(MobileBy.id("org.wikipedia.alpha:id/main_drawer_donate_container"))
          .first()
          .$(By.className("android.widget.TextView"))
          .shouldHave(Condition.text("Donate"));
    });
  }
}
