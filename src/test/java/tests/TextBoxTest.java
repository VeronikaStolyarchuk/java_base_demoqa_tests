package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.ResultTextBoxForm;

public class TextBoxTest extends BaseTest{

    TextBoxPage textBoxPage = new TextBoxPage();
    ResultTextBoxForm resultTextBoxForm = new ResultTextBoxForm();

    @Test
    void successfulTextBoxForm(){

        textBoxPage
                .openTextBoxPage()
                .typeUserName(testData.userName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.permanentAddress)
                .submitForm();

        resultTextBoxForm
                .checkTexBoxResult(testData.userName)
                .checkTexBoxResult(testData.userEmail)
                .checkTexBoxResult(testData.currentAddress)
                .checkTexBoxResult(testData.permanentAddress);

    }

    @Test
    void invalidEmailTextBoxForm(){

        textBoxPage
                .openTextBoxPage()
                .typeUserName(testData.userName)
                .typeUserEmail(testData.invalidUserEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.permanentAddress)
                .submitForm();

        resultTextBoxForm.checkTexBoxNotResult();
    }
}
