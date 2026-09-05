package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PwdRecoveryPage {
    private final WebDriver driver;

    // Элементы формы восстановления пароля
    private final By PwdRecoveryText = By.xpath("//h2[text()='Восстановление пароля']");
    private final By emailField = By.xpath("(//input[@type='text'])[1]");
    private final By loginBottomButton = By.xpath("//a[text()='Войти']");

    public PwdRecoveryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Переход на страницу логина
    public PwdRecoveryPage clickLoginLink() {
        driver.findElement(loginBottomButton).click();
        return new PwdRecoveryPage(driver);
    }

}
