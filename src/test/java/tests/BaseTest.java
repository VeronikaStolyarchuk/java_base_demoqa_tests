package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import tests.testData.TestData;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    TestData testData = new TestData();

    @BeforeAll
    static void setupConfig() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; 

    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}
