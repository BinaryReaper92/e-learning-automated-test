package testObjects;

import ch.qos.logback.core.net.SyslogOutputStream;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LoginPage;
import utilities.*;

import java.io.IOException;


public class LoginPageTest extends BasePageTest {

    public LoginPageTest(WebDriver driver) {

        super(driver,LoginPage.class);
    }

    TakeScreenshot takeScreenshot = new TakeScreenshot();
    /*MySendKeys send = new MySendKeys();
    MyClick click = new MyClick();*/

    public void setUserName(String username) throws Exception {

        LoginPage.textEmail.clear();
        waitForElementToAppear(LoginPage.textEmail);
        MySendKeys.mySendKeys(LoginPage.textEmail, username);
        /*JavascriptExecutor jse = ((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].value=arguments[1]", LoginPage.textEmail, username);
        LoginPage.textEmail.sendKeys(Keys.TAB);*/
    }

    public void setPassword(String password) throws Exception {

        LoginPage.textPassword.clear();
        MySendKeys.mySendKeys(LoginPage.textPassword, password);


    }

    public void clickLogin() throws Exception {


        MyClick.baseClick( LoginPage.buttonLogin );
        //Thread.sleep(5000);


    }

    public void checkIfTitleIs(String title) throws IOException {

        String loginPageTitle = LoginPage.mainPageTitle.getText();
        System.out.println(loginPageTitle);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]")));


        if (loginPageTitle.equalsIgnoreCase(title)) {
            Log4j.info("Login page title is: " +title);
            Assert.assertTrue(true);
            Log4j.info("Login passed");
            ExcelUtilities.setCellData(ExcelUtilities.path, "Munka1",25,5, "Passed");
        } else {
            takeScreenshot.captureScreen(driver,"loginTest");
            Assert.fail();
            Log4j.info("Login failed");
            ExcelUtilities.setCellData(ExcelUtilities.path, "Munka1",25,5, "Failed");
        }

    }

    /*
    public void unableToClickLogin() throws Exception {

        if (LoginPage.disabledLoginButton.isEnabled()){
            takeScreenshot.captureScreen(driver,"loginTest");
            Assert.assertTrue(true);
            Log4j.info("Disabled button test failed");
            ExcelUtilities.setCellData(ExcelUtilities.path, "Munka1",10,5, "Passed");
        } else {
            Assert.fail();
            Log4j.info("Disabled button test passed");
            ExcelUtilities.setCellData(ExcelUtilities.path, "Munka1",10,5, "Failed");
        }
    }*/
    public void clickOnEmailField() throws Exception {
        MyClick.baseClick( LoginPage.textEmail);
    }
    public void clickOnPasswordField() throws Exception {
        MyClick.baseClick( LoginPage.textPassword);
    }

    public void emailErrorText(String error) throws IOException {
        String actualError = LoginPage.invalidEmail.getText();
        if (LoginPage.invalidEmail.isDisplayed() && actualError.equals(error)){
            Assert.assertEquals(error, actualError);
            Log4j.info("Email error text test passed");
        }else {
            takeScreenshot.captureScreen(driver,"loginTest");
            Assert.fail();
            Log4j.info("Email error text test failed");
        }
    }

    public void passwordErrorText(String error) throws IOException {
        String actualError = LoginPage.invalidPassword.getText();
        if (LoginPage.invalidPassword.isDisplayed() && actualError.equals(error)){
            Assert.assertEquals(error, actualError);
            Log4j.info("Password error text test passed");
        }else {
            takeScreenshot.captureScreen(driver,"loginTest");
           Assert.fail();
            Log4j.info("Password error text test failed");
        }
    }

    public void loginErrorText(String error) throws IOException {
        String actualError = LoginPage.errorLogin.getText();
        if (LoginPage.errorLogin.isDisplayed() && actualError.equals(error)){
            Assert.assertEquals(error, actualError);
            Log4j.info("Login error text test passed");
            ExcelUtilities.setCellData(ExcelUtilities.path, "Munka1",22,5, "Passed");
        }else {
            takeScreenshot.captureScreen(driver,"loginTest");
            Log4j.info("Login error text test failed");
            ExcelUtilities.setCellData(ExcelUtilities.path, "Munka1",22,5, "Failed");
            Assert.fail();
        }
    }

    public void clickEye() throws Exception {
        MyClick.baseClick( LoginPage.buttonEye );
    }

    public void clickForgotPassword() throws Exception {
        MyClick.baseClick(LoginPage.buttonForgotPassword);

    }
}
