package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Function;

public class BasePageTest {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePageTest(WebDriver driver, Class aClass) {
        this.driver = driver;
        //wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(driver, aClass);
    }

    protected void waitForElementToAppear(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    static Boolean isPageReady(WebDriver driver, Integer waitSeconds) throws InterruptedException {
        Instant timestampOriginal = Instant.now();
        while (!isReady(driver) && timestampOriginal.until(Instant.now(), ChronoUnit.SECONDS) < waitSeconds) {
            Thread.sleep(1000);
        }
        if (isReady(driver)) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean isReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.readyState").equals("complete");
    }




}

