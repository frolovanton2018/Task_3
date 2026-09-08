package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest extends BaseTest {

    @Test
    @DisplayName("Переход из формы регистрации на форму авторизации")
    @Step("Переход из формы регистрации на форму авторизации")
    void testLoginFromRegistration() {
        driver.findElement(StellarHomePage.loginButton).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickGoToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginLink();
        loginPage.assertFormElementsVisible();
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }


    @Test
    @DisplayName("Переход в Личный кабинет")
    @Step("Переход в Личный кабинет")
    void proceedToLoginPage() {
        driver.findElement(StellarHomePage.loginButton).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.assertFormElementsVisible();
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @DisplayName("Переход в Конструктор из ЛК по логотипу")
    @Step("Переход в Конструктор из ЛК по логотипу")
    void proceedToConstructorByHeaderLogoFromLoginPage() {
        driver.findElement(StellarHomePage.loginButton).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickConstructorLink();
        assertTrue(stellarHomePage.findElementWithText("Соберите бургер").isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("/"));
    }

    @Test
    @DisplayName("Переход в Конструктор из ЛК")
    @Step("Переход в Конструктор из ЛК")
    void proceedToConstructorByLinkFromLoginPage() {
        driver.findElement(StellarHomePage.loginButton).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickConstructorLink();
        assertTrue(stellarHomePage.findElementWithText("Соберите бургер").isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("/"));
    }

    @Test
    @DisplayName("Переход на страницу регистрации")
    @Step("Переход на страницу регистрации")
    void testGoToRegistrationPage() {
        driver.findElement(StellarHomePage.loginButton).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickGoToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.assertFormElementsVisible();
        assertTrue(driver.getCurrentUrl().contains("/register"));
    }
}
