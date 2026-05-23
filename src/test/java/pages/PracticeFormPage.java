package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    CalendarComponent calendar = new CalendarComponent();

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement dateOfBirth = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private SelenideElement pictureLabel = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement stateWrapper= $("#stateCity-wrapper");
    private SelenideElement citySelect = $("#city");
    private SelenideElement cityWrapper= $("#stateCity-wrapper");
    private SelenideElement submitButton = $("#submit");



    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

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

    public PracticeFormPage setDateOfBirth(String day, String month, String year){
        dateOfBirth.click();
        calendar.setDate(day, month, year);

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

    //public PracticeFormPage setStateAndCity(String state, String city){
    //   setState(state);
    //   setCity(city);

    //   return this;
    //}

    public PracticeFormPage submitForm(){
        submitButton.click();

        return this;
    }

    public PracticeFormPage submitFormNotVisible(){
        submitButton.shouldNotBe(visible);

        return this;
    }

}







