package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import pages.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {


    @Test
    @DisplayName("Проверка логаута из аккаунта")
    @Step("Проверка выхода из аккаунта")
    void logOutTest() {
        String randomName = "TestUser" + new Random().nextInt(10000);
        String randomEmail = "test" + new Random().nextInt(10000) + "@test.com";
        String randomPassword = "Pass" + new Random().nextInt(10000);

        // Сначала регистрируемся
        driver.findElement(StellarHomePage.loginButton).click();
        new LoginPage(driver).clickGoToRegistration();
        new RegistrationPage(driver).register(randomName, randomEmail, randomPassword);
        new StellarHomePage(driver).clickLogo();
        new StellarHomePage(driver).waitForLoadHomePage();


        driver.findElement(StellarHomePage.lkButton).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(randomEmail, randomPassword);

        stellarHomePage.waitForLoadHomePage();
        assertTrue(driver.getCurrentUrl().contains("/"));
        assertTrue(driver.findElement(StellarHomePage.placeOrderButton).isDisplayed());

        driver.findElement(StellarHomePage.lkButton).click();
        new ProfilePage(driver).waitForProfilePageLoad();
        new ProfilePage(driver).clickLogoutButton();
        loginPage.assertFormElementsVisible();
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
