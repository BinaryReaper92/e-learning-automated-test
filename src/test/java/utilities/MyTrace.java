package utilities;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class MyTrace {

    public static void trace(String sMessage)
    {
        System.out.println( "[MYTRACE]" + sMessage );
        executeJavaScript("console.log(`"+sMessage+"`)");
    }

    public static void trace(SelenideElement element, String sMessage )
    {
        String sPrintMessage = sMessage;
        if(element != null) {
            sPrintMessage =  sPrintMessage + " " + element.getTagName();
        }
        MyTrace.trace(sPrintMessage);
    }

    public static void trace(SelenideElement element, String sMessage, Exception e )
    {
        MyTrace.trace(element, sMessage + " " + e.getMessage());
    }
}
