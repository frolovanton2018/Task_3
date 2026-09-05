package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.StellarHomePage;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegativeRegistrationTest extends BaseTest {

    @Test
    @DisplayName("Регистрация с заполнением только поля Имя")
    @Step("Регистрация с заполнением только поля Имя")
    void registrationWithOnlyName() {
        driver.findElement(StellarHomePage.loginButton).click();
        new LoginPage(driver).clickGoToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillName("TestUser");
        registrationPage.clickRegisterButton();

        assertTrue(driver.getCurrentUrl().contains("/register"));
    }

    @Test
    @DisplayName("Регистрация с заполнением только поля Email")
    @Step("Регистрация с заполнением только поля Email")
    void registrationWithOnlyEmail() {
        driver.findElement(StellarHomePage.loginButton).click();
        new LoginPage(driver).clickGoToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillEmail("test@test.com");
        registrationPage.clickRegisterButton();

        assertTrue(driver.getCurrentUrl().contains("/register"));
    }

    @Test
    @DisplayName("Регистрация с заполнением только поля Пароль")
    @Step("Регистрация с заполнением только поля Пароль")
    void registrationWithOnlyPassword() {
        driver.findElement(StellarHomePage.loginButton).click();
        new LoginPage(driver).clickGoToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillPassword("Pass123");
        registrationPage.clickRegisterButton();

        assertTrue(driver.getCurrentUrl().contains("/register"));
    }

    @Test
    @DisplayName("Проверка Ошибки для некорректного пароля. Минимальный пароль — шесть символов.")
    @Step("Проверка ошибки для некорректного пароля при регистрации")
    void registrationAttemptWithShortPassword() {
        String shortPassword = String.valueOf(new Random().nextInt(90000) + 10000);

        driver.findElement(StellarHomePage.loginButton).click();
        new LoginPage(driver).clickGoToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillName("TestUser");
        registrationPage.fillEmail("test@test.com");
        registrationPage.fillPassword(shortPassword);
        registrationPage.clickRegisterButton();

        assertTrue(driver.getCurrentUrl().contains("/register"));
        assertTrue(driver.findElement(registrationPage.incorrectPasswordText).isDisplayed());
    }
}
