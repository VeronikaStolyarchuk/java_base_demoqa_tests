package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import utils.JsSnippets;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    CalendarComponent calendar = new CalendarComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirth = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement pictureLabel = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement stateWrapper= $("#stateCity-wrapper");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement cityWrapper= $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalContent = $(".modal-content");

    public PracticeFormPage openPage(){

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        JsSnippets.removeBanner();

        return this;
    }

    public PracticeFormPage typeFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value){
        genderContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage typeUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String month, String year, String day){
        dateOfBirth.click();
        calendar.setDate(month, year, day);

        return this;
    }

    public PracticeFormPage typeSubjects(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value){
        hobbiesContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage uploadPicture(String value){
        pictureLabel.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage typeCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value){
        stateSelect.click();
        stateWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setCity(String value){
        citySelect.click();
        cityWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage submitForm(){
        submitButton.click();

        return this;
    }

    public void submitFormNotVisible(){
        modalContent.shouldNotBe(visible);

    }

    public PracticeFormPage scrollMethod(){
        executeJavaScript("window.scrollBy(0, 500)");

        return this;
    }

}







