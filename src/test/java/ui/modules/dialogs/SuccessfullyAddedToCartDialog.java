package ui.modules.dialogs;

import org.openqa.selenium.By;
import ui.controls.Button;
import ui.pages.OrderPage;
import ui.pages.PageFactory;

public class SuccessfullyAddedToCartDialog extends BaseDialog {
    private Controllable<Button> continueShoppingButton = () -> new Button(this, By.cssSelector(".continue"));
    private Controllable<Button> checkoutButton = () -> new Button(this, By.cssSelector("[title='Proceed to checkout']"));

    public SuccessfullyAddedToCartDialog() {
        super(By.id("layer_cart"));
    }

    public void continueShopping() {
        continueShoppingButton.get().click();
    }

    public OrderPage checkout() {
        checkoutButton.get().click();
        return PageFactory.create(OrderPage.class);
    }
}
