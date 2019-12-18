package ui.modules.ordersteps;

import org.openqa.selenium.By;
import ui.controls.Checkbox;

public class OrderShippingStep extends BaseOrderSteps {
    private Controllable<Checkbox> agreeTermsOfServiceCheckbox = () -> new Checkbox(this, By.id("cgv"));

    public OrderShippingStep agreeToTermsOfService() {
        agreeTermsOfServiceCheckbox.get().check();
        return this;
    }
}
