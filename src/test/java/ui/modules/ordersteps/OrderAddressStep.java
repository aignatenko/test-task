package ui.modules.ordersteps;

import org.openqa.selenium.By;
import ui.controls.Button;

public class OrderAddressStep extends BaseOrderSteps {
    private Controllable<Button> proceedCheckoutButton = () -> new Button(this, By.name("processAddress"));

    @Override
    public void goNextStep() {
        proceedCheckoutButton.get().click();
    }
}
