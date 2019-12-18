package ui.pages;

import ui.modules.forms.AccountCreationDetailsForm;
import ui.modules.forms.CreateAccountForm;

public class AuthenticationPage extends BasePage<AuthenticationPage> {
    public CreateAccountForm createAccountForm = new CreateAccountForm();
    public AccountCreationDetailsForm accountCreationDetailsForm = new AccountCreationDetailsForm();

    AuthenticationPage() {
        super("?controller=authentication");
    }
}
