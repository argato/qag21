package tests.real;

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
public class MenuRuRealAndroidSelenideTests extends RealTestBase {

  @Test
  @DisplayName("Проверка текстов на страницах")
  void searchTest() {
    back();

    step("CНажать Лента", () -> {
      $(MobileBy.AccessibilityId("Лента")).click();
    });
    step("Проверить текст заголовка", () ->
        $$(MobileBy.id("org.wikipedia.alpha:id/view_announcement_text"))
            .shouldHave(texts(
                "Настройте свою ленту")));

    step("Нажать Сохранено", () -> {
      $(MobileBy.AccessibilityId("Сохранено")).click();
    });
    step("Проверить текст заголовка", () ->
        $$(MobileBy.id("org.wikipedia.alpha:id/messageTitleView"))
            .shouldHave(texts("Синхронизировать список для чтения")));

    step("Нажать Правки", () -> {
      $(MobileBy.AccessibilityId("Правки")).click();
    });
    step("Проверить текст заголовка", () ->
        $$(MobileBy.id("org.wikipedia.alpha:id/positiveButton"))
            .shouldHave(texts("Войти в википедию")));

    step("Нажать Ещё", () -> {
      $(MobileBy.AccessibilityId("Ещё")).click();
    });
    step("Проверить текст заголовка", () ->
        $$(MobileBy.id("org.wikipedia.alpha:id/main_drawer_login_button"))
            .shouldHave(texts("Войти в википедию")));
    step("Проверить текст пункта меню", () -> {
      $$(MobileBy.id("org.wikipedia.alpha:id/main_drawer_history_container"))
          .first()
          .$(By.className("android.widget.TextView"))
          .shouldHave(Condition.text("История"));
    });
    step("Проверить текст пункта меню", () -> {
      $$(MobileBy.id("org.wikipedia.alpha:id/main_drawer_settings_container"))
          .first()
          .$(By.className("android.widget.TextView"))
          .shouldHave(Condition.text("Настройки"));
    });
    step("Проверить текст пункта меню", () -> {
      $$(MobileBy.id("org.wikipedia.alpha:id/main_drawer_donate_container"))
          .first()
          .$(By.className("android.widget.TextView"))
          .shouldHave(Condition.text("Пожертвовать"));
    });
  }
}