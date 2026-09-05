package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Вход в ЛК через кнопку на главной Личный кабинет",
            "Вход в ЛК через кнопку на главной Войти в аккаунт",
            "Вход в ЛК через кнопку Войти на странице регистрации",
            "Вход в ЛК через кнопку Войти на странице восстановления пароля"})
    @DisplayName("Перезод в ЛК через разные пути перехода в ЛК с главной страницы")
    @Step("Переход в ЛК через разные пути: {buttonName}")
    void loginWithCredentialsFromDifferentEntryPoint(String buttonName) {
        String randomName = "TestUser" + new Random().nextInt(10000);
        String randomEmail = "test" + new Random().nextInt(10000) + "@test.com";
        String randomPassword = "Pass" + new Random().nextInt(10000);

        // Сначала регистрируемся
        driver.findElement(StellarHomePage.loginButton).click();
        new LoginPage(driver).clickGoToRegistration();
        new RegistrationPage(driver).register(randomName, randomEmail, randomPassword);
        new StellarHomePage(driver).clickLogo();
        new StellarHomePage(driver).waitForLoadHomePage();

        switch (buttonName) {
            case "Вход в ЛК через кнопку на главной Личный кабинет":
                driver.findElement(StellarHomePage.lkButton).click();
                break;
            case "Вход в ЛК через кнопку на главной Войти в аккаунт":
                driver.findElement(StellarHomePage.loginButton).click();
                break;
            case "Вход в ЛК через кнопку Войти на странице регистрации":
                driver.findElement(StellarHomePage.lkButton).click();
                new LoginPage(driver).clickGoToRegistration();
                new RegistrationPage(driver).clickLoginLink();
                break;
            case "Вход в ЛК через кнопку Войти на странице восстановления пароля":
                driver.findElement(StellarHomePage.lkButton).click();
                new LoginPage(driver).clickGoToRecovery();
                new PwdRecoveryPage(driver).clickLoginLink();
                break;
        }

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(randomEmail, randomPassword);

        stellarHomePage.waitForLoadHomePage();
        assertTrue(driver.getCurrentUrl().contains("/"));
        assertTrue(driver.findElement(StellarHomePage.placeOrderButton).isDisplayed());
    }

    @Test
    @DisplayName("Проверка Ошибки для некорректного пароля. Минимальный пароль — шесть символов.")
    @Step("Проверка ошибки для некорректного пароля")
    void loginWithIncorrectPasswordLength() {
        String randomEmail = "test" + new Random().nextInt(10000) + "@test.com";
        String shortPassword = String.valueOf(new Random().nextInt(90000) + 10000);

        driver.findElement(StellarHomePage.lkButton).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(randomEmail, shortPassword);
        loginPage.clickLoginSubmit();
        assertTrue(driver.findElement(loginPage.incorrectPasswordText).isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("/login"));
        assertTrue(driver.findElements(StellarHomePage.placeOrderButton).isEmpty());
    }
}
