package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.ResultTextBoxForm;

import static tests.testData.TestData.*;

public class TextBoxTest extends BaseTest{

    TextBoxPage textBoxPage = new TextBoxPage();
    ResultTextBoxForm resultTextBoxForm = new ResultTextBoxForm();

    @Test
    void successfulTextBoxForm(){

        textBoxPage
                .openTextBoxPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm();

        resultTextBoxForm
                .checkTexBoxResult(userName)
                .checkTexBoxResult(userEmail)
                .checkTexBoxResult(currentAddress)
                .checkTexBoxResult(permanentAddress);

    }

    @Test
    void invalidEmailTextBoxForm(){

        textBoxPage
                .openTextBoxPage()
                .typeUserName(userName)
                .typeUserEmail(invalidUserEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm();

        resultTextBoxForm.checkTexBoxNotResult();
    }
}
