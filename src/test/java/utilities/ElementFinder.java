package utilities;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class ElementFinder {


    public static SelenideElement myFindElementById(String locator){
        try {
            return $(getWebDriver().findElement(By.id(locator)));
        } catch (ElementNotFound e) {
           // MyTrace.trace($(By.id(locator)), "Unable to find element");
            System.out.println("Unable to find element " + e.getMessage());
        }
        return null;
    }

    public static SelenideElement myFindElementByCSS(String locator){
        try {
            return $(getWebDriver().findElement(By.cssSelector(locator)));
        } catch (NoSuchElementException e) {
            MyTrace.trace($(By.cssSelector(locator)), "Unable to find element", e);
            System.out.println("Unable to find element " + e.getMessage());
        }
        return null;
    }

    public static SelenideElement myFindElementByXpath(String locator){
        try {
            return $(getWebDriver().findElement(By.xpath(locator)));
        } catch (NoSuchElementException e) {
            MyTrace.trace($(By.xpath(locator)), "Unable to find element", e);
            System.out.println("Unable to find element " + e.getMessage());
        }
        return null;
    }

    public static SelenideElement myFindElementByText(String locator){
        try {
            return $(getWebDriver().findElement(By.xpath(".//*[text()='" + locator + "'] ")));
        } catch (NoSuchElementException e) {
            MyTrace.trace($(By.xpath(".//*[text()='" + locator + "'] ")), "Unable to find element", e);
            System.out.println("Unable to find element " + e.getMessage());
        }
        return null;
    }

    public static SelenideElement myFindElementByLinkText(String locator){
        try {
            return $(getWebDriver().findElement(By.linkText(locator)));
        } catch (NoSuchElementException e) {
            MyTrace.trace($(By.linkText(locator)), "Unable to find element" + locator + "in", e);
            System.out.println("Unable to find element " + e.getMessage());
        }
        return null;
    }
/*
    public static SelenideElement myFindElement(String locator){
       SelenideElement element;
        element = myFindElementByXpath(locator);
        if( element == null )
           element = myFindElementById(locator);
       if( element == null )
           element = myFindElementByLinkText(locator);
       if( element == null )
           element = myFindElementByText(locator);
       if( element == null )
           element = myFindElementByLinkText(locator);
       if( element == null )
           element = myFindElementByCSS(locator);

       if( element == null )
           MyTrace.trace($By.element(locator)"Unable to find element " + locator + " in" e);
           System.out.println("Unable to find element " + e.getm());

       return element;
    }*/

    public static SelenideElement myFindElement(String locator){
        SelenideElement element = null;
        element = myFindElementById(locator);

        if (element == null) {
            element = myFindElementByXpath(locator);
        }
        if (element == null) {
            element = myFindElementByLinkText(locator);
        }
        if (element == null) {
            element = myFindElementByText(locator);
        }
        if (element == null) {
            element = myFindElementByLinkText(locator);
        }
        if (element == null) {
            element = myFindElementByCSS(locator);
        }
        if (element == null) {
            MyTrace.trace(null, "Unable to find element " + locator);
            System.out.println("Unable to find element");
        }
        return element;
    }

/*
    public static SelenideElement myFindElement2(String locator) {
        SelenideElement element = null;
        if (locator != null) {
            try {
                element = $(getWebDriver().findElement(By.id(locator)));
            } catch (NoSuchElementException e) {
                // do nothing, element not found with xpath
            }
        }

        if (element == null) {
            try {
                element = $(getWebDriver().findElement(By.xpath(locator)));
            } catch (NoSuchElementException e) {
                // do nothing, element not found with id
            }
        }

        if (element == null) {
            try {
                element = $(By.cssSelector(locator));
            } catch (NoSuchElementException e) {
                // do nothing, element not found with css selector
            }
        }

        if (element == null) {
            MyTrace.trace(null, "Unable to find element " + locator + " in");
            System.out.println("Unable to find element");
        }

        return element;
    }*/
}
