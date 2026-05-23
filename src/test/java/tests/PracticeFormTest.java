package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultPracticeFormTable;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testData.TestData.*;

public class PracticeFormTest extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ResultPracticeFormTable resultPracticeFormTable = new ResultPracticeFormTable();



    @Test
    void successfulPracticeForm(){
        practiceFormPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .setGender(userGender)
                .typeUserNumber(phoneNumber)
                .setDateOfBirth(dayBirth, monthBirth, yearBirth)
                .typeSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(picture)
                .typeCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm();


        resultPracticeFormTable.checkModal()
                .checkTableResult("Student Name", userFirstName + " " +userLastName)
                //.checkTableResult(userLastName)
                .checkTableResult("Student Email", userEmail)
                .checkTableResult("Gender", userGender)
                .checkTableResult("Mobile", phoneNumber)
                .checkTableResult("Date of Birth", dateOfBirth)
                .checkTableResult("Subjects", subject)
                .checkTableResult("Hobbies", hobby)
                .checkTableResult("Picture", picture)
                .checkTableResult("Address", currentAddress)
                .checkTableResult("State and City", state + " " + city)


                .closeModal();

    }

    @Test
    void successfulRequiredFields(){
        practiceFormPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .setGender(userGender)
                .typeUserNumber(phoneNumber)
                .submitForm();

        resultPracticeFormTable.checkModal()
                .checkTableResult("Student Name", userFirstName + " " + userLastName)
                .checkTableResult("Student Email", userEmail)
                .checkTableResult("Gender", userGender)
                .checkTableResult("Mobile", phoneNumber);
    }

    @Test
    void invalidEmailPracticeForm(){
        practiceFormPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(invalidUserEmail)
                .setGender(userGender)
                .typeUserNumber(phoneNumber)
                .submitForm();

        $(".modal-content").shouldNotBe(visible);
    }

    @Test
    void invalidPhonePracticeForm(){
        practiceFormPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .setGender(userGender)
                .typeUserNumber(invalidPhoneNumber);

        $(".modal-content").shouldNotBe(visible);
    }

    @Test
    void emptyGenderPracticeForm(){
        practiceFormPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .setGender(userGender);

        $(".modal-content").shouldNotBe(visible);
    }




}
