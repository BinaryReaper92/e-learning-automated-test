package stepDefinitions2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage2;
import testObjects.LoginPageTest;
import testObjects.LoginPageTest2;
import utilities.JSONReader;
import utilities.Log4j;
import utilities.TestSetup;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps2 {


    private JSONReader reader = new JSONReader();


    @Given("Admin opens URL {string}")
    public void admin_opens_url(String url) {
        String sWebsite = reader.getAddress(url).getAddress();
        Log4j.info("Opening the website:" + sWebsite);
        open(sWebsite);
    }


    @And("Admin enters Email as {string}")
    public void admin_enters_email_as(String role) throws Exception {
        Log4j.info("Enter email");
        LoginPageTest2.setUserName(reader.getUser(role).getEmail());

    }


    @And("Admin enters Password as {string}")
    public void admin_enters_password_as(String role) throws Exception {
        Log4j.info("Enter password");
        LoginPageTest2.setPassword(reader.getUser(role).getPassword());

    }

    @And("Admin click on Login")
    public void admin_click_on_login() throws Exception {
        Log4j.info("Click on login button");
        LoginPageTest2.clickLogin();

    }

    @And("Admin leaves Email as blank")
    public void adminLeavesEmailAsBlank() throws Exception {
        Log4j.info("Click on email field");
        LoginPageTest2.clickEmail();

    }

    @And("Admin leaves Password as blank")
    public void adminLeavesPasswordAsBlank() throws Exception {
        Log4j.info("Click on password field");
        LoginPageTest2.clickPassword();

    }

    @Then("Email and Password error message should display as {string}")
    public void emailAndPasswordErrorMessageShouldDisplayAs(String error) throws Exception {
        Log4j.info("Email and Password fields are empty");
        LoginPageTest2.missingCredentials(error);
    }
}