package bokoff.il.demoqa;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("demoqa")
public class RegistrationFormTest {

  @BeforeAll
  static void setUp(){
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";

  }

  @Test
  void fillFormTest(){
    String firstName = "Ilya";
    String lastName = "Bokov";
    String email = "bokoff.il@gmail.com";
    String mobilePhone = "1111111111";
    String subjects="English";
    String gender="Male";
    String filePath= "test.jpg";
    String currentAddress="1st Street";
    String dateOfBirth="30 August,2000";
    String hobby="Sports";
    String state="NCR";
    String city="Delhi";
    SelenideElement stateElement =$("#state");
    SelenideElement cityElement =$("#city");

    step("Open registration form",()->{
      open("/automation-practice-form");
    });

    step("Fill registation form",()->{
      $("#firstName").setValue(firstName);
      $("#lastName").setValue(lastName);
      $("#userEmail").setValue(email);
      $(byText(gender)).click();
      $("#userNumber").setValue(mobilePhone);
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select").selectOption("August");
      $(".react-datepicker__year-select").selectOption("2000");
      $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month").click();
      $("#subjectsInput").setValue(subjects).pressEnter();
      $(byText(hobby)).click();
      $("#uploadPicture").uploadFromClasspath(filePath);
      $("#currentAddress").setValue(currentAddress);
      stateElement.click();
      stateElement.$(byText(state)).click();
      cityElement.click();
      cityElement.$(byText(city)).click();
      $("#submit").click();
    });


    step("Verify form data",()->{
      $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
      $(".table-responsive").shouldHave(
          text(firstName),
          text(lastName),
          text(email),
          text(mobilePhone),
          text(gender),
          text(dateOfBirth),
          text(subjects),
          text(hobby),
          text("test.jpg"),
          text(currentAddress),
          text(state + " " + city));
    });
  }
}
