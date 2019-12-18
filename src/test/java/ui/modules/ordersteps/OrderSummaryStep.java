package ui.modules.ordersteps;

import org.openqa.selenium.By;
import ui.controls.Label;

public class OrderSummaryStep extends BaseOrderSteps {

    private Controllable<Label> cartItemTitleLabel = () -> new Label(this, By.cssSelector(".cart_item .product-name > a"));

    public int getCartItemsCount() {
        return cartItemTitleLabel.get().getCount();
    }

    public String getCartItemTitleByIndex(int index) {
        return ((Label) cartItemTitleLabel.get().byIndex(index)).getText();
    }
}
