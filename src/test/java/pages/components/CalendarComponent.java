package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static tests.testData.TestData.dayBirth;

public class CalendarComponent {

    private final SelenideElement monthOfBirth = $(".react-datepicker__month-select");
    private final SelenideElement yearOfBirth = $(".react-datepicker__year-select");
    private final SelenideElement dayOfBirth = $(".react-datepicker__day--0" + dayBirth + ":not(.react-datepicker__day--outside-month)");

    public void setDate(String day, String month, String year){
        monthOfBirth.selectOption(month);
        yearOfBirth.selectOption(year);
        dayOfBirth.click();
    }
}
