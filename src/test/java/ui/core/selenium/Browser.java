package ui.core.selenium;

import logger.TestsLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class Browser {

    public void get(String s) {
        execute(() -> getWebDriver().get(s));
    }

    public String getCurrentUrl() {
        return execute(() -> getWebDriver().getCurrentUrl());
    }

    public String getTitle() {
        return execute(() -> getWebDriver().getTitle());
    }

    List<WebElement> findElements(By by) {
        return getWebDriver().findElements(by);
    }

    WebElement findElement(By by) {
        return getWebDriver().findElement(by);
    }

    public String getPageSource() {
        return execute(() -> getWebDriver().getPageSource());
    }

    public void close() {
        execute(() -> getWebDriver().close());
    }

    public void quit() {
        execute(() -> getWebDriver().quit());
    }

    public Set<String> getWindowHandles() {
        return execute(() -> getWebDriver().getWindowHandles());
    }

    public String getWindowHandle() {
        return execute(() -> getWebDriver().getWindowHandle());
    }

    public WebDriver.TargetLocator switchTo() {
        return execute(() -> getWebDriver().switchTo());
    }

    public WebDriver.Navigation navigate() {
        return execute(() -> getWebDriver().navigate());
    }

    public WebDriver.Options manage() {
        return execute(() -> getWebDriver().manage());
    }

    private <T> T execute(Supplier<T> supplier) {
        TestsLogger.info(buildLogMessage());
        T result;
        try {
            result = supplier.get();
        } catch (Exception e) {
            //todo: handle exception;
            throw e;
        }
        return result;
    }

    private void execute(Runnable runnable) {
        TestsLogger.info(buildLogMessage());
        try {
            runnable.run();
        } catch (Exception e) {
            //todo: handle exception;
            throw e;
        }
    }

    private WebDriver getWebDriver() {
        return WebDriverFactory.getDriver();
    }

    private String buildLogMessage() {
        String method = Thread.currentThread().getStackTrace()[3].getMethodName();
        return String.format("WebDriver is performing %1$s() action", method);
    }
}
