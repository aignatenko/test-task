package ui.core.selenium;

import logger.TestsLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import ui.controls.BaseControl;
import ui.modules.BaseModule;

import java.util.List;
import java.util.function.Supplier;

public class Element<T extends BaseControl> {

    private By _by;
    private BaseModule _parent;
    private int elementIndex = 0;

    protected Element(BaseModule parent, By by) {
        _by = by;
        _parent = parent;
    }

    protected Element(By by) {
        _by = by;
    }

    public T byIndex(int index) {
        this.elementIndex = index;
        return (T) this;
    }

    public boolean isDisplayed() {
        return execute(() -> findWebElement().isDisplayed());
    }

    protected void click() {
        execute(() -> findWebElement().click());
    }

    protected void submit() {
        execute(() -> findWebElement().submit());
    }

    protected void select(String value) {
        execute(() -> new Select(findWebElement()).selectByValue(value));
    }

    protected void selectByText(String text) {
        execute(() -> new Select(findWebElement()).selectByVisibleText(text));
    }

    protected void select(int index) {
        execute(() -> new Select(findWebElement()).selectByIndex(index));
    }

    protected void sendKeys(CharSequence... charSequences) {
        execute(() -> findWebElement().sendKeys(charSequences));
    }

    protected void clear() {
        execute(() -> findWebElement().clear());
    }

    protected String getTagName() {
        return execute(() -> findWebElement().getTagName());
    }

    protected String getAttribute(String attributeName) {
        return execute(() -> findWebElement().getAttribute(attributeName));
    }

    protected boolean isSelected() {
        return execute(() -> findWebElement().isSelected());
    }

    protected boolean isEnabled() {
        return execute(() -> findWebElement().isEnabled());
    }

    protected String getText() {
        return execute(() -> findWebElement().getText());
    }

    protected int getCount() {
        return execute(() -> findWebElements().size());
    }

    protected Point getLocation() {
        return execute(() -> findWebElement().getLocation());
    }

    protected Dimension getSize() {
        return execute(() -> findWebElement().getSize());
    }

    protected Rectangle getRect() {
        return execute(() -> findWebElement().getRect());
    }

    protected String getCssValue(String s) {
        return execute(() -> findWebElement().getCssValue(s));
    }

    protected <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return execute(() -> findWebElement().getScreenshotAs(outputType));
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
        TestsLogger.info("Result: " + result);
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

    private WebElement findWebElement() {
        if (elementIndex > 0)
            return findWebElements().get(elementIndex);
        if (_parent != null)
            return ((Element) _parent).findWebElement().findElement(_by);
        return new Browser().findElement(_by);
    }

    private List<WebElement> findWebElements() {
        if (_parent != null)
            return ((Element) _parent).findWebElement().findElements(_by);
        return new Browser().findElements(_by);
    }

    private String buildLogMessage() {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String controlName = getClass().getSimpleName();
        String parentName = _parent.getClass().getSimpleName();
        return String.format("%1$s  %2$s(%3$s) on the %4$s", methodName, controlName, _by, parentName);
    }
}
