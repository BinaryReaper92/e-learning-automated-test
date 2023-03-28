package utilities;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class MySendKeys {



    private static boolean standardSendKeys(SelenideElement element, String text) throws Exception {

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

    public static boolean javaScriptSendKeys (SelenideElement element, String text) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                MyTrace.trace( element, "Send text to element with using java script sendkeys" );
                js.executeScript("arguments[0].value=arguments[1];", element, text);
                js.executeScript("var event = new Event('change'); arguments[0].dispatchEvent(event);", element);
                element.shouldHave(value(text));
             //   js.executeScript("arguments[0].dispatchEvent(new window.Event('change'));", element);
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

    public static boolean jquerySendKeys(SelenideElement element, String text) {

        try {if (element.isEnabled() && element.isDisplayed()) {

            String jqueryScript = String.format("$('#%s').val('%s');", element, text);
            executeJavaScript(jqueryScript);
            MyTrace.trace(element, "Send text to element with using jquery sendkeys");
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
        MyTrace.trace( element, "Successful jquery send text on element" );
        return true;
    }

    public static void mySendKeys( SelenideElement element, String text) throws Exception {
        if( !standardSendKeys( element, text ) )
                 javaScriptSendKeys( element, text);
                 jquerySendKeys(element, text);

    }


}
