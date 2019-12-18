package ui.modules.ordersteps;

import org.openqa.selenium.By;
import ui.controls.Button;
import ui.controls.Label;
import ui.controls.Link;

public class OrderPaymentStep extends BaseOrderSteps {
    private Controllable<Link> bankWireLink = () -> new Link(this, By.className("bankwire"));
    private Controllable<Button> confirmOrderButton = () -> new Button(this, By.cssSelector("#cart_navigation>button[type='submit']"));
    private Controllable<Label> orderSuccessfullyCompletedMessage = () -> new Label(this, By.cssSelector(".cheque-indent>.dark"));

    public OrderPaymentStep payByBankWire() {
        bankWireLink.get().click();
        return this;
    }

    public OrderPaymentStep confirmOrder() {
        confirmOrderButton.get().click();
        return this;
    }

    public boolean isOrderSuccessfullyCompletedMessageDisplayed() {
        return orderSuccessfullyCompletedMessage.get().isDisplayed();
    }

    public String orderCompletedMessageText() {
        return orderSuccessfullyCompletedMessage.get().getText();
    }
}
