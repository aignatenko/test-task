package ui.modules.forms;

import org.openqa.selenium.By;
import ui.controls.TextInput;

public final class CreateAccountForm extends BaseForm {

    private Controllable<TextInput> createAnAccountButton = () -> new TextInput(this, By.id("email_create"));

    public CreateAccountForm() {
        super(By.id("create-account_form"));
    }

    public CreateAccountForm fillInEmailField(String email) {
        createAnAccountButton.get().sentKeys(email);
        return this;
    }
}
