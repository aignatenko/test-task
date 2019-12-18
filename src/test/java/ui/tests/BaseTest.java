package ui.tests;

import listener.EventListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import ui.core.selenium.Browser;


@Listeners(EventListener.class)
public abstract class BaseTest {

    private Browser browser;

    @BeforeClass
    public void beforeClass() {
        browser = new Browser();
    }

    @AfterClass
    public void afterClass() {
        browser.quit();
    }
}
