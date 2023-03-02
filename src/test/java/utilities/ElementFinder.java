package utilities;

import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Optional;
import org.openqa.selenium.*;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$x;


public class ElementFinder {

    public static WebDriver driver;

    public static WebElement myFindElementById(WebElement parentElement, String locator){
        try {
            return parentElement.findElement(By.id(locator));
        } catch (NoSuchElementException e) {
            MyTrace.trace( parentElement,"Unable to find element " + locator + " in", e );
            //System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }

    public static WebElement myFindElementById(String locator){
        try {
            return driver.findElement(By.id(locator));
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }

    public static WebElement myFindElementByCSS(WebElement parentElement, String locator){
        try {
            return parentElement.findElement(By.cssSelector(locator));
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }

    public static WebElement myFindElementByCSS(String locator){
        try {
            return driver.findElement(By.cssSelector(locator));
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }

    public static SelenideElement myFindElementByXpath(WebElement parentElement, String locator){
        try {
            return  $x(locator);
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }
    public static WebElement myFindElementByXpath(String locator){
        try {
            return driver.findElement(By.xpath(locator));
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }

    public static WebElement myFindElementByText(WebElement parentElement, String locator){
        try {
            return parentElement.findElement(By.xpath(".//*[text()='locator'] "));
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }
    public static WebElement myFindElementByText(String locator){
        try {
            return  driver.findElement(By.xpath(".//*[text()='locator'] "));
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }

    public static WebElement myFindElementByLinkText(WebElement parentElement, String locator){
        try {
            return parentElement.findElement(By.linkText(locator));
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }
    public static WebElement myFindElementByLinkText(String locator){
        try {
            return driver.findElement(By.linkText(locator));
        } catch (NoSuchElementException e) {
            System.out.println("Unable to find element " + e.getStackTrace());
        }
        return null;
    }

    public static WebElement myFindElement(WebElement parentElement, String locator){
       WebElement element;
        element = myFindElementByXpath(     parentElement, locator );
        if( element == null )
           element = myFindElementById(        parentElement, locator );
       if( element == null )
           element = myFindElementByLinkText(  parentElement, locator );
       if( element == null )
           element = myFindElementByText(      parentElement, locator );
       if( element == null )
           element = myFindElementByLinkText(  parentElement, locator );
       if( element == null )
           element = myFindElementByCSS(       parentElement, locator );

       if( element == null )
           MyTrace.trace( parentElement, "Unable to find element " + locator + " in" );

       return element;
    }

    public static WebElement myFindElement(String locator){
        WebElement element;
        element = myFindElementById(        locator );
        if( element == null )
        element = myFindElementByXpath(         locator );
        if( element == null )
            /*
            element = myFindElementByLinkText(  locator );
        if( element == null )
            element = myFindElementByText(      locator );
        if( element == null )
            element = myFindElementByLinkText(  locator );
        if( element == null )
            element = myFindElementByCSS(       locator );
            */
        if( element == null )
            MyTrace.trace( null, "Unable to find element " + locator + " in" );

        return element;
    }

}
