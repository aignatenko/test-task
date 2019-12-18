package ui.controls;

import org.openqa.selenium.By;
import ui.modules.BaseModule;

public class ListBox extends BaseControl {
    public ListBox(BaseModule parent, By selector) {
        super(parent, selector);
    }

    public void selectByValue(String value) {
        super.select(value);
    }

    public void selectByText(String text) {
        super.selectByText(text);
    }

    public void selectByIndex(int index) {
        super.select(index);
    }
}
