package pages;

import org.openqa.selenium.By;
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

    // метод выбора вкладки Соусы с ожиданием
    public void waitForScrollToSausesTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'current') and .//span[text()='Соусы']]")
        ));
    }

    // метод выбора вкладки Начинки с ожиданием
     public void waitForScrollToFillingsTab() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
         wait.until(ExpectedConditions.presenceOfElementLocated(
                 By.xpath("//div[contains(@class, 'current') and .//span[text()='Начинки']]")
         ));
     }

    // метод выбора вкладки Булки с ожиданием
    public void waitForBunsVisibilityTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'current') and .//span[text()='Булки']]")
        ));
    }

    // Найти элемент по тексту и вернуть WebElement
    public WebElement findElementWithText(String text) {
        return driver.findElement(By.xpath(String.format("//*[text()='%s']", text)));
    }
}
