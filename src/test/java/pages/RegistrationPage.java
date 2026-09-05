package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;

    // Элементы формы регистрации
    private final By registrationText = By.xpath("//h2[text()='Регистрация']");
    private final By nameField = By.xpath("(//input[@type='text'])[1]");
    private final By emailField = By.xpath("(//input[@type='text'])[2]");
    private final By passwordField = By.cssSelector("input[name='Пароль']");
    private final By registerSubmitButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginBottomButton = By.xpath("//a[text()='Войти']");
    public By incorrectPasswordText = By.xpath("//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Заполнение поля "Имя"
    public void fillName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Заполнение поля "Email"
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    // Заполнение поля "Пароль"
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Клик по кнопке "Зарегистрироваться"
    public void clickRegisterButton() {
        driver.findElement(registerSubmitButton).click();
    }

    // Регистрация с заполнением всех полей
    public void register(String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegisterButton();
    }

    // Переход на страницу логина
    public LoginPage clickLoginLink() {
        driver.findElement(loginBottomButton).click();
        return new LoginPage(driver);
    }

    // Проверка видимости элементов формы регистрации
    public void assertFormElementsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationText));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerSubmitButton));
    }
}
