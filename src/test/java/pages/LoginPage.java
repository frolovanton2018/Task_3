package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    // Страница Личный кабинет

    private final By registrationButton = By.xpath("//a[text()='Зарегистрироваться']");
    private final By recoveryButton = By.xpath("//a[text()='Восстановить пароль']");

    // Элементы формы логина
    private final By loginTest = By.xpath("//h2[text()='Вход']");
    private final By emailField = By.cssSelector("input[name='name']");
    private final By passwordField = By.cssSelector("input[name='Пароль']");
    private final By loginSubmitButton = By.xpath("//button[text()='Войти']");
    public By incorrectPasswordText = By.xpath("//p[text()='Некорректный пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Заполнение формы логина
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        clickLoginSubmit();
    }

    // Ссылка «Конструктор» в хедере на странице ЛК
    public void clickConstructorLink() {
        driver.findElement(StellarHomePage.constructorButton).click();
    }

    // Ссылка на страницу регистрации
    public void clickGoToRegistration() {
        driver.findElement(registrationButton).click();
    }

    // Ссылка на страницу восстановления пароля
    public void clickGoToRecovery() {
        driver.findElement(recoveryButton).click();
    }

    public void clickLoginSubmit() {
        driver.findElement(loginSubmitButton).click();
    }

    // Проверка видимости элементов формы логина
    public void assertFormElementsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginTest));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSubmitButton));
    }
}
