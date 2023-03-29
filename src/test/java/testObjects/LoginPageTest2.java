package testObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.LoginPage2;
import utilities.BasePageTest2;
import utilities.Log4j;
import utilities.MyClick;
import utilities.MySendKeys;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;


public class LoginPageTest2 extends BasePageTest2 {


    public static void setUserName(String username) throws Exception {

        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getEmailInput().shouldBe(visible);
        MySendKeys.mySendKeys(loginPage.getEmailInput(), username);
    }

    public static void setPassword(String password) throws Exception {

        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getPasswordInput().shouldBe(visible);
        MySendKeys.mySendKeys(loginPage.getPasswordInput(),password);


    }

    public static void clickLogin() throws Exception {

        Log4j.info("Click on Login button");
        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getLoginButton().shouldBe(visible);
        MyClick.baseClick(loginPage.getLoginButton());


    }

    public static void clickEmail() throws Exception {

        Log4j.info("Click in the Email field");
        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getEmailInput().shouldBe(visible);
        loginPage.getLoginButton().shouldBe(visible);
        MyClick.baseClick(loginPage.getEmailInput());


    }

    public static void clickPassword() throws Exception {

        Log4j.info("Click in the Password field");
        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getLoginButton().shouldBe(visible);
        loginPage.getLoginButton().shouldBe(visible);
        MyClick.baseClick(loginPage.getPasswordInput());


    }

    public static void missingCredentials(String error) throws Exception {

        Log4j.info("Missing credentials test started");
        LoginPage2 loginPage = page(LoginPage2.class);
        LoginPageTest2.clickLogin();
        loginPage.getEmailEmptyError().shouldBe(visible);
        loginPage.getPasswordEmptyError().shouldBe(visible);
        String actualEmailError = loginPage.getEmailEmptyError().getText();
        if (loginPage.getEmailEmptyError().isDisplayed() && actualEmailError.equals(error)){

            Log4j.info("Email error text test passed");
        }else {
            Assert.fail();
            Log4j.info("Email error text test failed");
        }

    }

    public static void MissingEmailError(String password) throws Exception {

        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getEmailInput().shouldBe(visible);
        loginPage.getPasswordInput().shouldBe(visible);
        loginPage.getLoginButton().shouldBe(visible);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        loginPage.getEmailEmptyError();

    }



}
