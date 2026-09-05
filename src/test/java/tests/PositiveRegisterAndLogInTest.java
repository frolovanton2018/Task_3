package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveRegisterAndLogInTest extends BaseTest {

    @Test
    @DisplayName("Полная регистрация с корректными данными и последующий вход")
    @Step("Полная регистрация с корректными данными и последующий вход")
    void fullRegistrationAndLogin() {
        driver.findElement(StellarHomePage.loginButton).click();
        new LoginPage(driver).clickGoToRegistration();

        String randomName = "TestUser" + new Random().nextInt(10000);
        String randomEmail = "test" + new Random().nextInt(10000) + "@test.com";
        String randomPassword = "Pass" + new Random().nextInt(10000);

        // Заполняем и регистрируемся
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register(randomName, randomEmail, randomPassword);

        // Переходим на страницу логина
        registrationPage.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);

        // Авторизуемся с теми же данными
        loginPage.login(randomEmail, randomPassword);

        // Ждём загрузки страницы
        stellarHomePage.waitForLoadHomePage();

        assertTrue(driver.getCurrentUrl().contains("/"));
        assertTrue(driver.findElement(StellarHomePage.placeOrderButton).isDisplayed());
    }
}
