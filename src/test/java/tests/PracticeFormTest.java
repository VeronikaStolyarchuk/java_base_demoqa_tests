package tests;

import org.junit.jupiter.api.Test;
import utils.JsSnippets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testData.TestData.*;

public class PracticeFormTest extends BaseTest {

    @Test
    void successfulTextBoxForm(){
        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));

    }

    @Test
    void invalidEmailTextBoxForm(){
        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue("alex.com");
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

        $("#output").shouldNotBe(visible);

    }

    @Test
    void successfulPracticeForm(){
        open("/automation-practice-form");
        JsSnippets.removeBanner();
        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(userGender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirth-wrapper").click();
        $(".react-datepicker__month-select").selectOption(monthBirth);
        $(".react-datepicker__year-select").selectOption(yearBirth);
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        executeJavaScript("window.scrollBy(0, 500)");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(text(userFirstName + " " + userLastName));
        $(".modal-body").shouldHave(text(userEmail));
        $(".modal-body").shouldHave(text(userGender));
        $(".modal-body").shouldHave(text(phoneNumber));
        $(".modal-body").shouldHave(text(dayBirth + " " + monthBirth + "," + yearBirth));
        $(".modal-body").shouldHave(text(subject));
        $(".modal-body").shouldHave(text(hobby));
        $(".modal-body").shouldHave(text(picture));
        $(".modal-body").shouldHave(text(currentAddress));
        $(".modal-body").shouldHave(text(state + " " + city));

    }

    @Test
    void successfulRequiredFields(){
        open("/automation-practice-form");
        JsSnippets.removeBanner();
        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#genterWrapper").$(byText(userGender)).click();
        executeJavaScript("window.scrollBy(0, 500)");
        $("#userNumber").setValue(phoneNumber);
        $("#submit").click();

        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(text(userFirstName + " " + userLastName));
        $(".modal-body").shouldHave(text(userGender));
        $(".modal-body").shouldHave(text(phoneNumber));

    }

    @Test
    void invalidEmailPracticeForm(){
        open("/automation-practice-form");
        JsSnippets.removeBanner();
        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue("1111.ru");
        $("#genterWrapper").$(byText(userGender)).click();
        $("#userNumber").setValue(phoneNumber);

        $(".modal-content").shouldNotBe(visible);
    }

    @Test
    void invalidPhonePracticeForm(){
        open("/automation-practice-form");
        JsSnippets.removeBanner();
        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(userGender)).click();
        $("#userNumber").setValue("asdfghjklz");

        $(".modal-content").shouldNotBe(visible);

    }

    @Test
    void emptyGenderPracticeForm(){
        open("/automation-practice-form");
        JsSnippets.removeBanner();
        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userNumber").setValue(phoneNumber);

        $(".modal-content").shouldNotBe(visible);

    }
}
