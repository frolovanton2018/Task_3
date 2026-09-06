package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.StellarHomePage;

public class BaseTest {

    protected WebDriver driver;
    protected StellarHomePage stellarHomePage;

    private static final String BASE_URL = "https://qa-stellarburgers.education-services.ru/";
    
    protected WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Неизвестный браузер: " + browser);
        }
    }

    @BeforeEach
    public void setUp() {
        driver = createDriver("chrome");
        driver.get(BASE_URL);
        stellarHomePage = new StellarHomePage(driver);
        stellarHomePage.waitForLoadHomePage();
    }

    @AfterEach
    public void tearDown() {
            driver.quit();
        }
    }
