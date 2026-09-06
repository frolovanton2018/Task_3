package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StellarHomePage {

    private final WebDriver driver;
    // Элементы главной страницы
    public StellarHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Логотип в шапке
    public static final By headerLogo = By.cssSelector("[class*='header__logo']");

    // Кнопка Конструктор
    public static final By constructorButton = By.xpath("(//*[contains(@class, 'AppHeader_header__linkText')])[1]");

    // Кнопка Лента заказов
    public final By feedButton = By.xpath("(//*[contains(@class, 'AppHeader_header__linkText')])[2]");

    // Кнопка "Войти в аккаунт"
    public static final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");

    // Кнопка "личный кабинет"
    public static final By lkButton = By.xpath("//p[text()='Личный Кабинет']");

    // Заголовок Соберите бургер
    public static final By makeBurgerText = By.xpath("//h1[text()='Соберите бургер']");

    // Кнопка "Булки"
    public static final By bunsButton = By.xpath("(//*[contains(@class, 'tab_tab')])[1]");

    // Кнопка "Соусы"
    public static final By sauceButton = By.xpath("//span[text()='Соусы']");

    // Кнопка "начинки"
    public static final By fillingsButton = By.xpath("(//*[contains(@class, 'tab_tab')])[3]");

    // Кнопка Оформить заказ (после авторизации)
    public static final By placeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    // Метод клика на Логотип в хедере
    public void clickLogo() {
        driver.findElement(headerLogo).click();
    }

    // Метод ожидания загрузки страницы
    public void waitForLoadHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text() = 'Соберите бургер']")));
    }

    // Переход в ЛК через кнопку Войти в аккаунт
    public void clickGoToLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Переход в ЛК через кнопку Личный кабинет
    public void clickLkButton() {
        driver.findElement(lkButton).click();
    }

    // метод проверки с ожиданием видимости соусов
    public void waitForSausesVisibility(String sauseName) {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[text()='%s']", sauseName))));
    }

    // метод проверки с ожиданием видимости соусов
    public void waitForBunsVisibility(String bunName) {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[text()='%s']", bunName))));
    }

    // метод проверки с ожиданием видимости начинок
    public void waitForFillingsVisibility(String fillingName) {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[text()='%s']", fillingName))));
    }

    // Найти элемент по тексту и вернуть WebElement
    public WebElement findElementWithText(String text) {
        return driver.findElement(By.xpath(String.format("//*[text()='%s']", text)));
    }

    // Проверка, что элемент находится в viewport
    public boolean isElementInViewport(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (boolean) js.executeScript(
                "var rect = arguments[0].getBoundingClientRect(); " +
                "return rect.top >= 0 && rect.left >= 0 && " +
                "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
                "rect.right <= (window.innerWidth || document.documentElement.clientWidth);",
                element
        );
    }
}
