package ui.controls;

import org.openqa.selenium.By;
import ui.modules.BaseModule;

public class TextInput extends BaseControl {
    public TextInput(BaseModule parent, By selector) {
        super(parent, selector);
    }

    public void sentKeys(CharSequence... charSequences) {
        super.sendKeys(charSequences);
    }

    public void clear() {
        super.clear();
    }
}
