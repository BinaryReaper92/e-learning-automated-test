package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import testObjects.LoginPageTest;
import utilities.JSONReader;
import utilities.Log4j;
import utilities.TestSetup;

import java.io.IOException;

public class LoginSteps{


    private WebDriver driver = TestSetup.driver;
    public LoginPageTest loginPageTest = new LoginPageTest(driver);

    private JSONReader reader = new JSONReader();


    @Given("Admin opens URL {string}")
    public void admin_opens_url(String url) {
        Log4j.info("Opening the website");
        driver.get(url);

    }

    @And("Admin enters Email as {string}")
    public void admin_enters_email_as(String role) throws InterruptedException {
        Log4j.info("Enter email");
        loginPageTest.setUserName(reader.getUser(role).getEmail());

    }

    @And("Admin enters Password as {string}")
    public void admin_enters_password_as(String role) {
        Log4j.info("Enter password");
        loginPageTest.setPassword(reader.getUser(role).getPassword());

    }

    @And("Admin click on Login")
    public void admin_click_on_login() {
        Log4j.info("Click on login button");
        loginPageTest.clickLogin();

    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) throws IOException {

        loginPageTest.login(title);

    }


}
