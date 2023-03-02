package utilities;

import org.openqa.selenium.*;


public class MyClick{

    public static WebDriver driver;

    private static boolean standardClick( WebElement element) throws Exception {
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

    private static boolean javaScriptClick( WebElement element) throws Exception {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                MyTrace.trace( element, "Clicking on element with standard click" );
                JavascriptExecutor js = (JavascriptExecutor) driver;
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

    public static void baseClick( WebElement element ) throws Exception {
        if( !standardClick( element ) )
            javaScriptClick( element );
    }

}
