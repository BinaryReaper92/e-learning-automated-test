package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;


public class MySendKeys {

    public static WebDriver driver;


    private static boolean standardSendKeys(WebElement element, String text) throws Exception {

        try {
            if (element.isEnabled() && element.isDisplayed()) {
                MyTrace.trace( element, "Send text to element with using standard sendkeys" );
                element.clear();
                element.sendKeys(text);
            } else {
                MyTrace.trace( element, "Unable to send text to element" );
                assert false;
                return false;
            }
        } catch (StaleElementReferenceException e) {
            MyTrace.trace( element, "Element is not attached to the page document", e );
            return false;
        } catch (NoSuchElementException e) {
            MyTrace.trace( element, "Element was not found in DOM", e );
            return false;
        } catch (Exception e) {
            MyTrace.trace( element, "Unable to send text to element", e );
            return false;
        }
        MyTrace.trace( element, "Successful standard send text on element" );
        return true;
    }

    public static boolean javaScriptSendKeys (WebElement element, String text) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                MyTrace.trace( element, "Send text to element with using java script sendkeys" );
                js.executeScript("arguments[0].value=arguments[1]", element, text);

            } else {
                MyTrace.trace( element, "Unable to send text to element" );
                assert false;
                return false;
            }
        } catch (StaleElementReferenceException e) {
            MyTrace.trace( element, "Element is not attached to the page document", e );
            return false;
        } catch (NoSuchElementException e) {
            MyTrace.trace( element, "Element was not found in DOM", e );
            return false;
        } catch (Exception e) {
            MyTrace.trace( element, "Unable to send text to element", e );
            return false;
        }
        MyTrace.trace( element, "Successful javaScript send text on element" );
        return true;
    }

    public void javas (WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=arguments[1]", element, text);
    }

    public static void mySendKeys( WebElement element, String text) throws Exception {
        if( !standardSendKeys( element, text ) )
           javaScriptSendKeys( element, text);
    }




}
