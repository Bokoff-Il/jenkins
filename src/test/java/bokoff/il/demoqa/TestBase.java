package bokoff.il.demoqa;

import bokoff.il.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
  @BeforeAll
  static void setUp(){
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
  }

  @AfterEach
  void addAttachments(){
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
  }
}
