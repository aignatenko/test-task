package ui.modules.ordersteps;

import org.openqa.selenium.By;
import ui.controls.Button;
import ui.modules.BaseModule;

public abstract class BaseOrderSteps extends BaseModule {
    private BaseModule.Controllable<Button> proceedCheckoutButton = () -> new Button(this, By.cssSelector(".standard-checkout"));

    BaseOrderSteps() {
        super(By.id("center_column"));
    }

    public void goNextStep() {
        proceedCheckoutButton.get().click();
    }
}
