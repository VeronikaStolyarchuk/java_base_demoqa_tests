package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testData.testData.*;

public class PracticeFormTest extends BaseTest {

    @Test
    void successfulTextBoxForm(){
        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text(userName));
        $("[id=output] [id=email]").shouldHave(text(userEmail));
        $("[id=output] [id=currentAddress]").shouldHave(text(currentAddress));
        $("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddress));

    }

    @Test
    void invalidEmailTextBoxForm(){
        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue("alex.com");
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();

        $("#output").shouldNotBe(visible);
    }

    @Test
    void successfulPracticeForm(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue(userFirstName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(userEmail);
        $("#genterWrapper").$(byText(userGender)).click();
        $("[id=userNumber]").setValue(phoneNumber);
        $("#dateOfBirth-wrapper").click();
        $(".react-datepicker__month-select").selectOption(monthBirth);
        $(".react-datepicker__year-select").selectOption(yearBirth);
        $(".react-datepicker__day--004").click();
        $("[id=subjectsInput]").setValue(subject).pressEnter();
        $("[id=hobbiesWrapper]").$(byText(hobby)).click();
        $("[id=uploadPicture]").uploadFromClasspath(picture);
        executeJavaScript("window.scrollBy(0, 500)");
        $("[id=currentAddress]").setValue(currentAddress);
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
        $("[id=firstName]").setValue(userFirstName);
        $("[id=lastName]").setValue(userLastName);
        $("#genterWrapper").$(byText(userGender)).click();
        executeJavaScript("window.scrollBy(0, 500)");
        $("[id=userNumber]").setValue(phoneNumber);
        $("#submit").click();

        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(text(userFirstName + " " + userLastName));
        $(".modal-body").shouldHave(text(userGender));
        $(".modal-body").shouldHave(text(phoneNumber));

    }

    @Test
    void invalidEmailPracticeForm(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue(userFirstName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue("1111.ru");
        $("#genterWrapper").$(byText(userGender)).click();
        $("[id=userNumber]").setValue(phoneNumber);

        $(".modal-content").shouldNotBe(visible);
    }

    @Test
    void invalidPhonePracticeForm(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue(userFirstName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(userEmail);
        $("#genterWrapper").$(byText(userGender)).click();
        $("[id=userNumber]").setValue("asdfghjklz");

        $(".modal-content").shouldNotBe(visible);
    }

    @Test
    void emptyGenderPracticeForm(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue(userFirstName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userNumber]").setValue(phoneNumber);

        $(".modal-content").shouldNotBe(visible);
    }




}
