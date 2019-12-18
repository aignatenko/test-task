package ui.pages;

import ui.modules.ordersteps.OrderAddressStep;
import ui.modules.ordersteps.OrderPaymentStep;
import ui.modules.ordersteps.OrderShippingStep;
import ui.modules.ordersteps.OrderSummaryStep;

public class OrderPage extends BasePage {
    public OrderSummaryStep summaryStep = new OrderSummaryStep();
    public OrderAddressStep addressStep = new OrderAddressStep();
    public OrderShippingStep shippingStep = new OrderShippingStep();
    public OrderPaymentStep paymentStep = new OrderPaymentStep();

    OrderPage() {
        super("?controller=order");
    }


}
