package web;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FillingFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void CheckForm() {
        registrationPage.openAutomationPracticeForm()
                .fillName()
                .fillEmail()
                .chooseGender()
                .fillPhoneNumber()
                .setDateOfBirth()
                .setSubject()
                .chooseHobby()
                .uploadPicture()
                .fillAddress()
                .selectStateAndCity()
                .submitClick()
                .compareValuesWithWeb();
    }
}
