package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import testObjects.LoginPageTest;
import utilities.JSONReader;
import utilities.Log4j;
import utilities.TestSetup;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import java.io.IOException;

public class LoginSteps{


    private WebDriver driver = null;
    public LoginPageTest loginPageTest = new LoginPageTest(driver);

    private JSONReader reader = new JSONReader();


    @Given("Admin opens URL {string}")
    public void admin_opens_url(String url) {
        String sWebsite = reader.getAddress(url).getAddress();
        Log4j.info("Opening the website:" + sWebsite);
        open(sWebsite);
    }
    /*
    @Given("Admin opens URL {string}")
    public void admin_opens_url(String url) {
        String sWebsite = reader.getAddress(url).getAddress();
        Log4j.info("Opening the website:" + sWebsite);
        driver.get( sWebsite );
    }
     */

    @And("Admin enters Email as {string}")
    public void admin_enters_email_as(String role) throws Exception {
        Log4j.info("Enter email");
        loginPageTest.setUserName(reader.getUser(role).getEmail());

    }

    /*
        @And("Admin enters Email as {string}")
    public void admin_enters_email_as(String role) throws Exception {
        Log4j.info("Enter email");
        loginPageTest.setUserName(reader.getUser(role).getEmail());

    }
     */

    @And("Admin enters Password as {string}")
    public void admin_enters_password_as(String role) throws Exception {
        Log4j.info("Enter password");
        loginPageTest.setPassword(reader.getUser(role).getPassword());

    }

    @And("Admin click on Login")
    public void admin_click_on_login() throws Exception {
        Log4j.info("Click on login button");
        loginPageTest.clickLogin();

    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) throws IOException {

        loginPageTest.checkIfTitleIs(title);

    }


    /*
    @Then("Admin can't click on Login")
    public void adminCanTClickOnLogin() throws Exception {

        loginPageTest.unableToClickLogin();
    }*/

    @And("Admin leaves Email as blank")
    public void adminLeavesEmailAsBlank() throws Exception {
        Log4j.info("Click on email field");
        loginPageTest.clickOnEmailField();
        
    }

    @Then("Email error message should display as {string}")
    public void emailErrorMessageShouldDisplay(String error) throws IOException {
        Log4j.info("Email field empty error message");
        loginPageTest.emailErrorText(error);
    }

    @And("Admin leaves Password as blank")
    public void adminLeavesPasswordAsBlank() throws Exception {
        Log4j.info("Click on password field");
        loginPageTest.clickOnPasswordField();
        
    }

    @Then("Password error message should display as {string}")
    public void passwordErrorMessageShouldDisplay(String error) throws IOException {
        Log4j.info("Password field empty error message");
        loginPageTest.passwordErrorText(error);
    }

    @Then("Login error message should display as {string}")
    public void loginErrorMessageShouldDisplay(String error) throws IOException {
        Log4j.info("Invalid login error message");
        loginPageTest.loginErrorText(error);
    }

    @Given("Admin Hoover on Login button")
    public void admin_hoover_on_login_button() {
        Log4j.info("Hoover on Login button");

        throw new io.cucumber.java.PendingException();
    }

    @Then("Login button's color should change to yellow")
    public void login_button_s_color_should_change_to_yellow() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Admin click on Eye icon")
    public void admin_click_on_eye_icon() throws Exception {
        Log4j.info("Click on Eye icon");
        loginPageTest.clickEye();
        throw new io.cucumber.java.PendingException();
    }

    @Then("Password should be visible")
    public void password_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Admin click on Forgot password")
    public void admin_click_on_forgot_password() throws Exception {
        Log4j.info("Click on Forgot Password");
        loginPageTest.clickForgotPassword();
        throw new io.cucumber.java.PendingException();
    }

    @Then("Forgot password modal should appear")
    public void forgot_password_modal_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}


