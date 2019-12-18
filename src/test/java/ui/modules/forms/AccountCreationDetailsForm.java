package ui.modules.forms;

import entities.User;
import entities.enums.GenderTitle;
import org.openqa.selenium.By;
import ui.controls.ListBox;
import ui.controls.RadioButton;
import ui.controls.TextInput;

public class AccountCreationDetailsForm extends BaseForm {
    private Controllable<RadioButton> mrRadioButton = () -> new RadioButton(this, By.id("id_gender1"));
    private Controllable<RadioButton> mrsRadioButton = () -> new RadioButton(this, By.id("id_gender2"));
    private Controllable<TextInput> firstNameTextInput = () -> new TextInput(this, By.id("customer_firstname"));
    private Controllable<TextInput> lastNameTextInput = () -> new TextInput(this, By.id("customer_lastname"));
    private Controllable<TextInput> emailTextInput = () -> new TextInput(this, By.id("email"));
    private Controllable<TextInput> passwordInput = () -> new TextInput(this, By.id("passwd"));
    private Controllable<TextInput> addressFirstNameTextInput = () -> new TextInput(this, By.id("firstname"));
    private Controllable<TextInput> addressLastNameTextInput = () -> new TextInput(this, By.id("lastname"));
    private Controllable<TextInput> address1TextInput = () -> new TextInput(this, By.id("address1"));
    private Controllable<TextInput> cityTextInput = () -> new TextInput(this, By.id("city"));
    private Controllable<ListBox> stateListbox = () -> new ListBox(this, By.id("id_state"));
    private Controllable<TextInput> zipTextInput = () -> new TextInput(this, By.id("postcode"));
    private Controllable<ListBox> countryListbox = () -> new ListBox(this, By.id("id_country"));
    private Controllable<TextInput> mobileTextInput = () -> new TextInput(this, By.id("phone_mobile"));
    private Controllable<TextInput> addressAliasTextInput = () -> new TextInput(this, By.id("alias"));

    public AccountCreationDetailsForm() {
        super(By.id("account-creation_form"));
    }

    public AccountCreationDetailsForm selectTitle(GenderTitle title) {
        switch (title) {
            case MR:
                mrRadioButton.get().select();
                break;
            case MRS:
                mrsRadioButton.get().select();
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return this;
    }

    public AccountCreationDetailsForm enterFirstName(String value) {
        firstNameTextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm enterLastName(String value) {
        lastNameTextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm enterEmail(String value) {
        emailTextInput.get().clear();
        emailTextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm enterPassword(String value) {
        passwordInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm enterAddressFirstName(String value) {
        addressFirstNameTextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm enterAddressLastName(String value) {
        addressLastNameTextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm enterAddress1(String value) {
        address1TextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm selectState(String value) {
        stateListbox.get().selectByText(value);
        return this;
    }

    public AccountCreationDetailsForm enterCity(String value) {
        cityTextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm enterZip(String value) {
        zipTextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm selectCountry(String value) {
        countryListbox.get().selectByText(value);
        return this;
    }

    public AccountCreationDetailsForm enterMobileNumber(String value) {
        mobileTextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm enterAddressAlias(String value) {
        addressAliasTextInput.get().sentKeys(value);
        return this;
    }

    public AccountCreationDetailsForm fillInForm(User user) {
        selectTitle(user.getTitle());
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        //address
        enterAddressFirstName(user.getAddress().getFirstName());
        enterAddressLastName(user.getAddress().getLastName());
        enterAddress1(user.getAddress().getAddress1());
        selectCountry(user.getAddress().getCountry().getCountryName());
        selectState(user.getAddress().getState().getStateName());
        enterCity(user.getAddress().getCity());
        enterZip(user.getAddress().getZip());
        enterMobileNumber(user.getAddress().getMobile());
        enterAddressAlias(user.getAddress().getAddressAlias());
        return this;
    }
}
