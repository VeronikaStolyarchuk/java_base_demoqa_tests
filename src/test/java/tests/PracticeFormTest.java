package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultPracticeFormTable;
import static tests.testData.TestData.*;

public class PracticeFormTest extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ResultPracticeFormTable resultPracticeFormTable = new ResultPracticeFormTable();

    @Test
    void successfulPracticeForm(){

        practiceFormPage
                .openPage()
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

        resultPracticeFormTable
                .checkModal()
                .checkTableResult("Student Name", userFirstName + " " +userLastName)
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

        practiceFormPage
                .openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .setGender(userGender)
                .scrollMethod()
                .typeUserNumber(phoneNumber)
                .submitForm();

        resultPracticeFormTable
                .checkModal()
                .checkTableResult("Student Name", userFirstName + " " + userLastName)
                .checkTableResult("Student Email", userEmail)
                .checkTableResult("Gender", userGender)
                .checkTableResult("Mobile", phoneNumber);
    }

    @Test
    void invalidEmailPracticeForm(){

        practiceFormPage
                .openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(invalidUserEmail)
                .setGender(userGender)
                .scrollMethod()
                .typeUserNumber(phoneNumber)
                .submitForm()

                .submitFormNotVisible();
    }

    @Test
    void invalidPhonePracticeForm(){

        practiceFormPage
                .openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .setGender(userGender)
                .typeUserNumber(invalidPhoneNumber)

                .submitFormNotVisible();
    }

    @Test
    void emptyGenderPracticeForm(){

        practiceFormPage
                .openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .setGender(userGender)

                .submitFormNotVisible();
    }

}
