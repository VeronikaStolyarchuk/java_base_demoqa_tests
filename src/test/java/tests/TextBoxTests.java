package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void BeforeAll(){
        Configuration.browser = "chrome";
        Configuration.browserVersion = "144.0";
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; //default=4000
    }

    @Test
    void successfulFillFormTest(){
        open("/text-box");
        $("[id=userName]").setValue("Alex Black");
        $("[id=userEmail]").setValue("alex@black.com");
        $("[id=currentAddress]").setValue("first address 1");
        $("[id=permanentAddress]").setValue("second address 2");
        $("[id=submit]").click();

        $("[id=submit]").shouldHave(text("Alex Black"));
        $("").shouldHave(text("alex@black.com"));
        $("").shouldHave(text("first address 1"));
        $("").shouldHave(text("second address 2"));



    }
}
