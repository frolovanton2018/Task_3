package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StellarHomePage;

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
    void testSaucesSection() {
        driver.findElement(StellarHomePage.sauceButton).click();
        stellarHomePage.waitForSausesVisibility(SHIP_SAUSE);
        stellarHomePage.waitForSausesVisibility(SPICY_SAUSE);
    }

    @Test
    @DisplayName("Переход к разделу «Булки» и проверка видимости элементов Булки")
    @Step("Переход к разделу «Булки» и проверка видимости элементов")
    void testBunsSection() {
        // Булки выбраны по умолчанию, клик не нужен
        stellarHomePage.waitForBunsVisibility(KRAT_BULKA);
        stellarHomePage.waitForBunsVisibility(FLUR_BULKA);
    }

    @Test
    @DisplayName("Переход к разделу «Начинки» и проверка видимости элементов Начинки")
    @Step("Переход к разделу «Начинки» и проверка видимости элементов")
    void testFillingsSection() {
        driver.findElement(StellarHomePage.fillingsButton).click();
        stellarHomePage.waitForFillingsVisibility(MINERAL_FILLING);
        stellarHomePage.waitForFillingsVisibility(TREE_FILLING);
    }
}
