package utilities;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class MyClick{

    private static boolean standardClick( SelenideElement element) throws Exception {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                MyTrace.trace( element, "Clicking on element with standard click" );
                element.click();
            } else {
                MyTrace.trace( element, "Unable to click on element" );
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
            MyTrace.trace( element, "Unable to click on element", e );
            return false;
        }
        MyTrace.trace( element, "Successful standard click on element" );
        return true;
    }

    private static boolean javaScriptClick( SelenideElement element) throws Exception {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                MyTrace.trace( element, "Clicking on element with standard click" );
                JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
                js.executeScript("arguments[0].click();", element);
            } else {
                MyTrace.trace( element, "Unable to click on element" );
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
            MyTrace.trace( element, "Unable to click on element", e );
            return false;
        }
        MyTrace.trace( element, "Successful standard click on element" );

        return true;
    }

    public static void baseClick2( SelenideElement element ) throws Exception {
        if( !standardClick( element ) )
            javaScriptClick( element );
    }
    public static void baseClick( WebElement element ) throws Exception {
    }

}
