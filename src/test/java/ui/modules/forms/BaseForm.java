package ui.modules.forms;

import org.openqa.selenium.By;
import ui.controls.Button;
import ui.modules.BaseModule;

public abstract class BaseForm extends BaseModule {

    private Controllable<Button> submitFormButton = () -> new Button(this, By.cssSelector(".submit>button"));

    BaseForm(By selector) {
        super(selector);
    }

    public void submit() {
        submitFormButton.get().click();
    }
}
