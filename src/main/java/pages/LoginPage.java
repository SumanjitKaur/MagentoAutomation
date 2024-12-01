package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement loginButton;

    @FindBy(className = "welcome")
    private WebElement welcomeMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        inputText(emailField, email);
        inputText(passwordField, password);
        clickElement(loginButton);
    }

    public boolean isLoginSuccessful() {
        return waitForElement(welcomeMessage).isDisplayed();
    }
}
