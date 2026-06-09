package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ResultTextBoxForm {

    private final SelenideElement checkResult = $("#output");

    public ResultTextBoxForm checkTexBoxResult(String value) {
        checkResult.shouldHave(text(value));

        return this;
    }

    public void checkTexBoxNotResult() {
        checkResult.shouldNotBe(visible);
    }

}


