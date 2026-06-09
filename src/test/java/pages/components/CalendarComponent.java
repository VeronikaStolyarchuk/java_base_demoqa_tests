package pages.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent{
    private final SelenideElement monthOfBirth = $(".react-datepicker__month-select");
    private final SelenideElement yearOfBirth = $(".react-datepicker__year-select");
    private final SelenideElement dayOfBirth = $(".react-datepicker");

    public void setDate(String month, String year, String day){
        monthOfBirth.selectOption(month);
        yearOfBirth.selectOption(year);
        dayOfBirth.findElement(By.cssSelector(".react-datepicker__day--0" +day +":not(.react-datepicker__day--outside-month)")).click();
    }
}
