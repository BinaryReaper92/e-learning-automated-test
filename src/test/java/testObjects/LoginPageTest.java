package testObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import utilities.BasePageTest;
import utilities.Log4j;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LoginPageTest extends BasePageTest {

    public LoginPageTest(WebDriver driver) {

        super(driver,LoginPage.class);
    }

    public void setUserName(String username) {

        LoginPage.textEmail.clear();
        waitForElementToAppear(LoginPage.textEmail);
        LoginPage.textEmail.sendKeys(username);
    }

    public void setPassword(String password) {

        LoginPage.textPassword.clear();
        LoginPage.textPassword.sendKeys(password);
    }

    public void clickLogin() {

        LoginPage.buttonLogin.click();
    }

    public void login(String title) throws IOException {

        //LoginPage.errorLogin.getText().equals("Sikertelen bejelentkezés!");

        waitForLoad(driver);
        if (driver.getTitle().equals(title)) {
            Assert.assertTrue(true);
            Log4j.info("Login passed");
        } else {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            Log4j.info("Login failed");
        }
    }
}
