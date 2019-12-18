package ui.modules;

import org.openqa.selenium.By;
import ui.controls.Link;
import ui.pages.AuthenticationPage;
import ui.pages.PageFactory;

public final class UserTopToolbar extends BaseModule {

    private Controllable<Link> signInLink = () -> new Link(this, By.className("login"));
    private Controllable<Link> usernameLink = () -> new Link(this, By.className("account"));
    private Controllable<Link> signOutLink = () -> new Link(this, By.className("logout"));

    public UserTopToolbar() {
        super(By.className("nav"));
    }

    public AuthenticationPage clickSignInLink() {
        signInLink.get().click();
        return PageFactory.create(AuthenticationPage.class);
    }

    public String getLoggedInUsername() {
        return usernameLink.get().getText();
    }

    public boolean isSignOutLinkDisplayed() {
        return signOutLink.get().isDisplayed();
    }
}
