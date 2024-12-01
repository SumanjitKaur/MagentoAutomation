package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

public class AccountSteps {
    WebDriver driver = DriverManager.getDriver();
    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
    }

    @When("I navigate to the Create Account page")
    public void iNavigateToTheCreateAccountPage() {
        homePage.navigateToCreateAccount();
        accountPage = new AccountPage(driver);
    }

    @When("I fill in the account details and submit")
    public void iFillInTheAccountDetailsAndSubmit() {
        accountPage.createAccount("John", "Doe", "johndoe@example.com", "StrongPassword123!");
    }

    @Then("I should see the account creation success message")
    public void iShouldSeeTheAccountCreationSuccessMessage() {
        assert accountPage.isAccountCreated() : "Account creation failed!";
    }

    @When("I log out")
    public void iLogOut() {
        homePage.navigateToSignIn();
    }

    @When("I log in with the newly created account")
    public void iLogInWithTheNewlyCreatedAccount() {
        loginPage = new LoginPage(driver);
        loginPage.login("johndoe@example.com", "StrongPassword123!");
    }

    @Then("I should see the welcome message")
    public void iShouldSeeTheWelcomeMessage() {
        assert loginPage.isLoginSuccessful() : "Login failed!";
    }
}
