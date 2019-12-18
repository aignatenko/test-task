package ui.modules.dialogs;

import org.openqa.selenium.By;
import ui.controls.Button;
import ui.modules.BaseModule;

public class BaseDialog extends BaseModule {
    private Controllable<Button> closeDialogButton = () -> new Button(this, By.cssSelector("[title='Close window']"));

    BaseDialog(By selector) {
        super(selector);
    }

    public void closeDialog() {
        closeDialogButton.get().click();
    }
}
