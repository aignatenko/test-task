package ui.controls;

import org.openqa.selenium.By;
import ui.core.selenium.Element;
import ui.modules.BaseModule;

public abstract class BaseControl extends Element {

    public BaseControl(BaseModule parent, By selector) {
        super(parent, selector);
    }

}
