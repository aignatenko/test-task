package ui.pages;

import config.TestsConfiguration;
import logger.TestsLogger;
import org.testng.Assert;
import ui.core.selenium.Browser;
import ui.modules.UserTopToolbar;

public abstract class BasePage<T extends BasePage> {

    private static final Browser browser = new Browser();
    private final String url;
    public UserTopToolbar userTopToolbar = new UserTopToolbar();

    BasePage(String url) {
        Assert.assertTrue(url.startsWith("?"), "Relative page url must start from '?'");
        this.url = TestsConfiguration.baseUrl() + url;
    }

    public boolean isPageOpen() {
        TestsLogger.info(String.format("Is %s open", getClass().getSimpleName()));
        boolean result = browser.getCurrentUrl().equals(url);
        TestsLogger.info(String.format("Result: %s", result));
        return result;
    }

    public T open() {
        TestsLogger.info(String.format("Open %1$s by URL='%2$s'", getClass().getSimpleName(), url));
        browser.get(url);
        return (T) this;
    }

    public String title() {
        TestsLogger.info(String.format("Get %s title", getClass().getSimpleName()));
        String result = browser.getTitle();
        TestsLogger.info(String.format("Result: %s", result));
        return result;
    }
}
