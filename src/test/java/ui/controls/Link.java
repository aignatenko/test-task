package ui.controls;

import org.openqa.selenium.By;
import ui.modules.BaseModule;

public class Link extends BaseControl {

    public Link(BaseModule parent, By selector) {
        super(parent, selector);
    }

    public void click() {
        super.click();
    }

    public String getText() {
        return super.getText();
    }
}
