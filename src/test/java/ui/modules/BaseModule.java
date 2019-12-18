package ui.modules;

import org.openqa.selenium.By;
import ui.controls.BaseControl;
import ui.core.selenium.Element;

public abstract class BaseModule extends Element {

    public BaseModule(By selector) {
        super(selector);
    }

    @FunctionalInterface
    public interface Controllable<T extends BaseControl> {
        T get();
    }
}
