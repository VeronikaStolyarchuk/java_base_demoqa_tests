package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultPracticeFormTable;

public class PracticeFormTest extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ResultPracticeFormTable resultPracticeFormTable = new ResultPracticeFormTable();

    @Test
    void successfulPracticeForm(){

        practiceFormPage
                .openPage()
                .typeFirstName(testData.userFirstName)
                .typeLastName(testData.userLastName)
                .typeUserEmail(testData.userCorrectEmail)
                .setGender(testData.userGender)
                .scrollMethod()
                .typeUserNumber(testData.phoneNumber)
                .setDateOfBirth(testData.monthBirth, testData.yearBirth, testData.dayBirth)
                .typeSubjects(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture(testData.picture)
                .typeCurrentAddress(testData.currentAddressField)
                .setState(testData.state)
                .setCity(testData.city)
                .submitForm();

        resultPracticeFormTable
                .checkModal()
                .checkTableResult("Student Name", testData.userFirstName + " " +testData.userLastName)
                .checkTableResult("Student Email", testData.userCorrectEmail)
                .checkTableResult("Gender", testData.userGender)
                .checkTableResult("Mobile", testData.phoneNumber)
                .checkTableResult("Date of Birth", testData.dateOfBirth)
                .checkTableResult("Subjects", testData.subject)
                .checkTableResult("Hobbies", testData.hobby)
                .checkTableResult("Picture", testData.picture)
                .checkTableResult("Address", testData.currentAddressField)
                .checkTableResult("State and City", testData.state + " " + testData.city)

                .closeModal();

    }

    @Test
    void successfulRequiredFields(){

        practiceFormPage
                .openPage()
                .typeFirstName(testData.userFirstName)
                .typeLastName(testData.userLastName)
                .typeUserEmail(testData.userCorrectEmail)
                .setGender(testData.userGender)
                .scrollMethod()
                .typeUserNumber(testData.phoneNumber)
                .submitForm();

        resultPracticeFormTable
                .checkModal()
                .checkTableResult("Student Name", testData.userFirstName + " " + testData.userLastName)
                .checkTableResult("Student Email", testData.userCorrectEmail)
                .checkTableResult("Gender", testData.userGender)
                .checkTableResult("Mobile", testData.phoneNumber);
    }

    @Test
    void invalidEmailPracticeForm(){

        practiceFormPage
                .openPage()
                .typeFirstName(testData.userFirstName)
                .typeLastName(testData.userLastName)
                .typeUserEmail(testData.invalidUserEmail)
                .setGender(testData.userGender)
                .scrollMethod()
                .typeUserNumber(testData.phoneNumber)
                .submitForm()

                .submitFormNotVisible();
    }

    @Test
    void invalidPhonePracticeForm(){

        practiceFormPage
                .openPage()
                .typeFirstName(testData.userFirstName)
                .typeLastName(testData.userLastName)
                .typeUserEmail(testData.userCorrectEmail)
                .setGender(testData.userGender)
                .typeUserNumber(testData.invalidPhoneNumber)

                .submitFormNotVisible();
    }

    @Test
    void emptyGenderPracticeForm(){

        practiceFormPage
                .openPage()
                .typeFirstName(testData.userFirstName)
                .typeLastName(testData.userLastName)
                .typeUserEmail(testData.userCorrectEmail)
                .setGender(testData.userGender)

                .submitFormNotVisible();
    }

}
