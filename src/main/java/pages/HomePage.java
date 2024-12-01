package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;

    @FindBy(linkText = "Sign In")
    private WebElement signInLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToCreateAccount() {
        clickElement(createAccountLink);
    }

    public void navigateToSignIn() {
        clickElement(signInLink);
    }
}
