package ui.controls;

import org.openqa.selenium.By;
import ui.modules.BaseModule;

public class Button extends BaseControl {

    public Button(BaseModule parent, By selector) {
        super(parent, selector);
    }

    public void click() {
        super.click();
    }
}
