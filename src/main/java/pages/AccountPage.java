package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {
    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private WebElement createAccountButton;

    @FindBy(className = "message-success")
    private WebElement successMessage;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void createAccount(String firstName, String lastName, String email, String password) {
        inputText(firstNameField, firstName);
        inputText(lastNameField, lastName);
        inputText(emailField, email);
        inputText(passwordField, password);
        inputText(confirmPasswordField, password);
        clickElement(createAccountButton);
    }

    public boolean isAccountCreated() {
        return waitForElement(successMessage).isDisplayed();
    }
}
