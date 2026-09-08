package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private final WebDriver driver;

    // Страница Профиль

    private final By logoutButton = By.xpath("//button[text()='Выход']");

    // Элементы формы логина
    private final By nameField = By.cssSelector("input[name='name']");
    private final By loginEmailField = By.cssSelector("input[name='Пароль']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Ожидание загрузки страницы профиля
    public void waitForProfilePageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }

    // Кнопка «Выйти» в личном кабинете
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}