package web;

import config.DriverSettings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        // log that driver initialized
        DriverSettings.configure();
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}