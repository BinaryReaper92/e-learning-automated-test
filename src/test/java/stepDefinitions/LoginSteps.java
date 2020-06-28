package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import testObjects.LoginPageTest;
import utilities.JSONReader;
import utilities.TestSetup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginSteps{


    private WebDriver driver = TestSetup.driver;
    public LoginPageTest loginPageTest = new LoginPageTest(driver);

    private JSONReader reader = new JSONReader();


    @Given("Admin opens URL {string}")
    public void admin_opens_url(String url) {
        driver.get(url);

    }

    @And("Admin enters Email as {string}")
    public void admin_enters_email_as(String role) throws InterruptedException {
        loginPageTest.setUserName(reader.getUser(role).getEmail());

    }

    @And("Admin enters Password as {string}")
    public void admin_enters_password_as(String role) {
        loginPageTest.setPassword(reader.getUser(role).getPassword());

    }

    @And("Admin click on Login")
    public void admin_click_on_login() {
        loginPageTest.clickLogin();

    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) throws IOException {

        if (driver.getPageSource().contains("Sikertelen bejelentkezés!")) {
            //captureScreen();
            Assert.fail();
            driver.quit();
        }
        else {
            Assert.assertEquals(title, driver.getTitle());
        }

    }


}
