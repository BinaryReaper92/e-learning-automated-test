package testObjects;

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
       // loginPage.getEmailInput().sendKeys(username);
        MySendKeys.mySendKeys2(loginPage.getEmailInput(),username);

    }

    public static void setPassword(String password) throws Exception {

        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getPasswordInput().shouldBe(visible);
       // loginPage.getPasswordInput().sendKeys(password);
        MySendKeys.mySendKeys2(loginPage.getPasswordInput(),password);


    }

    public static void clickLogin() throws Exception {


        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getLoginButton().shouldBe(visible);
       // loginPage.getLoginButton().click();
        MyClick.baseClick2(loginPage.getLoginButton());


    }

    public static void clickEmail() throws Exception {


        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getEmailInput().shouldBe(visible);
        loginPage.getLoginButton().shouldBe(visible);
        loginPage.getEmailInput().click();


    }

    public static void clickPassword() throws Exception {


        LoginPage2 loginPage = page(LoginPage2.class);
        loginPage.getLoginButton().shouldBe(visible);
        loginPage.getLoginButton().shouldBe(visible);
        loginPage.getPasswordInput().click();


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
