package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultPracticeFormTable {

    private final SelenideElement openModal = $(".modal-dialog");
    private final SelenideElement modalBody = $(".modal-body");
    private final SelenideElement closeModal = $("#closeLargeModal");

    public ResultPracticeFormTable checkModal(){
        openModal.shouldBe(Condition.visible);

        return this;
    }

    public ResultPracticeFormTable checkTableResult(String key, String value){
        modalBody.$$("tr").findBy(text(key)).shouldHave(text(value));

        return this;
    }

    public void closeModal(){
        closeModal.click();
    }

}
