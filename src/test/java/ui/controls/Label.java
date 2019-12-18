package ui.controls;

import org.openqa.selenium.By;
import ui.modules.BaseModule;

public class Label extends BaseControl {
    public Label(BaseModule parent, By selector) {
        super(parent, selector);
    }

    public String getText() {
        return super.getText();
    }

    public boolean isDisplayed() {
        return super.isDisplayed();
    }

    public int getCount() {
        return super.getCount();
    }
}
