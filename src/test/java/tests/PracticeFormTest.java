
package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends BaseTest {

    @Test
    void SuccessfulTest_TextBoxForm(){
        open("/text-box");
        $("[id=userName]").setValue("Alex Black");
        $("[id=userEmail]").setValue("alex@black.com");
        $("[id=currentAddress]").setValue("first address 1");
        $("[id=permanentAddress]").setValue("second address 2");
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("Alex Black"));
        $("[id=output] [id=email]").shouldHave(text("alex@black.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));

    }

    @Test
    void NegativeTest_InvalidEmailTextBoxForm(){
        open("/text-box");
        $("[id=userName]").setValue("Alex Black");
        $("[id=userEmail]").setValue("alex.com");
        $("[id=currentAddress]").setValue("first address 1");
        $("[id=permanentAddress]").setValue("second address 2");
        $("[id=submit]").click();

        $("#output").shouldNotBe(visible);
    }

    @Test
    void SuccessfulTest_PracticeForm(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Vera");
        $("[id=lastName]").setValue("Ivanova");
        $("[id=userEmail]").setValue("1111@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("[id=userNumber]").setValue("9175642132");
        $("#dateOfBirth-wrapper").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--004").click();
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
        $("[id=hobbiesWrapper]").$(byText("Music")).click();
        $("[id=uploadPicture]").uploadFromClasspath("image.jpg");
        executeJavaScript("window.scrollBy(0, 500)");
        $("[id=currentAddress]").setValue("Moscow 111");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(text("Vera Ivanova"));
        $(".modal-body").shouldHave(text("1111@mail.ru"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("9175642132"));
        $(".modal-body").shouldHave(text("04 June,2000"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("image.jpg"));
        $(".modal-body").shouldHave(text("Moscow 111"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));


    }

    @Test
    void SuccessfulTest_RequiredFields(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Vera");
        $("[id=lastName]").setValue("Ivanova");
        $("#genterWrapper").$(byText("Female")).click();
        executeJavaScript("window.scrollBy(0, 500)");
        $("[id=userNumber]").setValue("9175642132");
        $("#submit").click();

        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(text("Vera Ivanova"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("9175642132"));

    }

    @Test
    void NegativeTest_InvalidEmail(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Vera");
        $("[id=lastName]").setValue("Ivanova");
        $("[id=userEmail]").setValue("1111.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("[id=userNumber]").setValue("9175642132");

        $(".modal-content").shouldNotBe(visible);
    }

    @Test
    void NegativeTest_InvalidPhone(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Vera");
        $("[id=lastName]").setValue("Ivanova");
        $("[id=userEmail]").setValue("1111@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("[id=userNumber]").setValue("asdfghjklz");

        $(".modal-content").shouldNotBe(visible);
    }

    @Test
    void NegativeTest_EmptyGender(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Vera");
        $("[id=lastName]").setValue("Ivanova");
        $("[id=userNumber]").setValue("9175642132");

        $(".modal-content").shouldNotBe(visible);
    }




}
