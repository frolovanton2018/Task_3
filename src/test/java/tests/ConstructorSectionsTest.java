package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.StellarHomePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorSectionsTest extends BaseTest {

    // константы для тестовых данных
    private static final String KRAT_BULKA = "Краторная булка N-200i";
    private static final String FLUR_BULKA = "Флюоресцентная булка R2-D3";
    private static final String SHIP_SAUSE = "Соус с шипами Антарианского плоскоходца";
    private static final String SPICY_SAUSE = "Соус Spicy-X";
    private static final String MINERAL_FILLING = "Хрустящие минеральные кольца";
    private static final String TREE_FILLING = "Плоды Фалленианского дерева";

    @Test
    @DisplayName("Переход к разделу «Соусы» и проверка видимости элементов Соусы")
    @Step("Переход к разделу «Соусы» и проверка видимости элементов")
    void testSaucesSection() throws InterruptedException {
        driver.findElement(StellarHomePage.sauceButton).click();
        Thread.sleep(1000);
        WebElement shipSause = driver.findElement(By.xpath("//*[text()='" + SHIP_SAUSE + "']"));
        WebElement spicySause = driver.findElement(By.xpath("//*[text()='" + SPICY_SAUSE + "']"));

        assertTrue(stellarHomePage.isElementInViewport(shipSause), "Элемент '" + SHIP_SAUSE + "' должен быть в видимой области");
        assertTrue(stellarHomePage.isElementInViewport(spicySause), "Элемент '" + SPICY_SAUSE + "' должен быть в видимой области");
    }

    @Test
    @DisplayName("Переход к разделу «Булки» и проверка видимости элементов Булки")
    @Step("Переход к разделу «Булки» и проверка видимости элементов")
    void testBunsSection() {
        // Булки выбраны по умолчанию, клик не нужен

        WebElement shipSause = driver.findElement(By.xpath("//*[text()='" + KRAT_BULKA + "']"));
        WebElement spicySause = driver.findElement(By.xpath("//*[text()='" + FLUR_BULKA + "']"));

        assertTrue(stellarHomePage.isElementInViewport(shipSause), "Элемент '" + SHIP_SAUSE + "' должен быть в видимой области");
        assertTrue(stellarHomePage.isElementInViewport(spicySause), "Элемент '" + KRAT_BULKA + "' должен быть в видимой области");
    }

    @Test
    @DisplayName("Переход к разделу «Начинки» и проверка видимости элементов Начинки")
    @Step("Переход к разделу «Начинки» и проверка видимости элементов")
    void testFillingsSection() throws InterruptedException {
        driver.findElement(StellarHomePage.fillingsButton).click();
        Thread.sleep(1000);

        WebElement shipSause = driver.findElement(By.xpath("//*[text()='" + MINERAL_FILLING + "']"));
        WebElement spicySause = driver.findElement(By.xpath("//*[text()='" + TREE_FILLING + "']"));

        assertTrue(stellarHomePage.isElementInViewport(shipSause), "Элемент '" + MINERAL_FILLING + "' должен быть в видимой области");
        assertTrue(stellarHomePage.isElementInViewport(spicySause), "Элемент '" + TREE_FILLING + "' должен быть в видимой области");
    }
}