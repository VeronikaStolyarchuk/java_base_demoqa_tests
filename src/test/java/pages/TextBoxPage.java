package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");

    public TextBoxPage openTextBoxPage(){
        open("/text-box");
        $(".col-12").shouldHave(text("Text Box"));

        return this;
    }

    public TextBoxPage typeUserName(String value){
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage typeUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage typeCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage typePermanentAddress(String value){
        permanentAddressInput.setValue(value);

        return this;
    }

    public void submitForm(){
        submitButton.click();
    }

}
