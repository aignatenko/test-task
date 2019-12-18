package ui.tests;

import assertions.Assertion;
import entities.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.modules.ordersteps.OrderPaymentStep;
import ui.pages.*;

public class TestTaskTests extends BaseTest {

    private User testUser = User.getRandomUser();

    /**
     * User creation is implemented here(in 'before class' method)
     * to make the tests independent each other and reduce the time of their execution
     */
    @BeforeClass(description = "Create new user for the tests")
    public void createUser() {
        HomePage home = PageFactory.create(HomePage.class);
        home.open();
        AuthenticationPage authPage = home.userTopToolbar.clickSignInLink();
        authPage.createAccountForm.fillInEmailField(testUser.getEmail()).submit();
        authPage.accountCreationDetailsForm.fillInForm(testUser).submit();
    }

    @Test(description = "Verify new user is created and logged in", priority = 0)
    public void checkUserCreated() {
        MyAccountPage myAccPage = PageFactory.create(MyAccountPage.class);
        Assertion.isTrue(myAccPage.isPageOpen(), "My account page is not opened after new user creation");
        Assertion.isTrue(myAccPage.userTopToolbar.isSignOutLinkDisplayed(), "Sign Out link is not displayed for newly created user");
        Assertion.areEqual(myAccPage.userTopToolbar.getLoggedInUsername(), String.format("%1$s %2$s", testUser.getFirstName(), testUser.getLastName()),
                "Logged in user name is not correct in the main toolbar menu");
    }

    @Test(description = "Buy 'cotton' dress and t-shirt of 'Soft and stretchy material' using wire transfer payment method", priority = 1)
    public void buyCottonDresses() {
        //Add a dress to the cart
        CatalogPage dressesPage = PageFactory.create(CatalogPage.class, CatalogPage.CatalogCategory.DRESSES);
        dressesPage.open();
        dressesPage.catalogGridViewPanel.openListView();
        dressesPage.catalogItemsGrid.getCatalogItemByDescription("cotton").addToCart().continueShopping();

        //Add a t-shirt to the cart
        CatalogPage t_shirtPage = PageFactory.create(CatalogPage.class, CatalogPage.CatalogCategory.TSHIRTS);
        t_shirtPage.open();
        OrderPage orderPage = t_shirtPage.catalogItemsGrid.getCatalogItemByDescription("Soft and stretchy material").addToCart().checkout();

        //Check the items is in the order
        Assertion.areEqual(orderPage.summaryStep.getCartItemsCount(), 2, "Incorrect items count added to the cart");
        Assertion.isTrue(orderPage.summaryStep.getCartItemTitleByIndex(0).contains("Dress"), "The first cart item is not dress");
        Assertion.isTrue(orderPage.summaryStep.getCartItemTitleByIndex(1).contains("T-shirt"), "The second cart item is not t-shirt");

        //Navigate to the payment order page
        orderPage.summaryStep.goNextStep();
        orderPage.addressStep.goNextStep();
        orderPage.shippingStep.agreeToTermsOfService().goNextStep();

        //Select bank wire payment and confirm the order
        OrderPaymentStep paymentOrderPage = orderPage.paymentStep.payByBankWire().confirmOrder();

        //Check the order is completed
        Assertion.isTrue(paymentOrderPage.isOrderSuccessfullyCompletedMessageDisplayed(), "Message that the order is completed successfully is not displayed");
        Assertion.areEqual(paymentOrderPage.orderCompletedMessageText(), "Your order on My Store is complete.", "Order completion message is incorrect");
    }
}
