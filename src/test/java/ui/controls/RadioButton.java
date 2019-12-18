package ui.controls;

import org.openqa.selenium.By;
import ui.modules.BaseModule;

public class RadioButton extends BaseControl {
    public RadioButton(BaseModule parent, By selector) {
        super(parent, selector);
    }

    public void select() {
        super.click();
    }
}
