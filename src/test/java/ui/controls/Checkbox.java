package ui.controls;

import org.openqa.selenium.By;
import ui.modules.BaseModule;

public class Checkbox extends BaseControl {
    public Checkbox(BaseModule parent, By selector) {
        super(parent, selector);
    }

    public void check() {
        if (!isChecked())
            super.click();
    }

    public void uncheck() {
        if (isChecked())
            super.click();
    }

    public boolean isChecked() {
        return super.isSelected();
    }
}
