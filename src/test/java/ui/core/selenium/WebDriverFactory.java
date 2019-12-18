package ui.core.selenium;

import config.TestsConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

class WebDriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();

    static WebDriver getDriver() {
        if (DRIVER.get() == null)
            DRIVER.set(createDriverInstance());
        return DRIVER.get();
    }

    private static WebDriver createDriverInstance() {
        WebDriver driver;
        switch (TestsConfiguration.browser()) {
            case chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(GetChromeOptions());
                break;
            case firefox:
            case edge:
            default:
                throw new UnsupportedOperationException();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private static ChromeOptions GetChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
