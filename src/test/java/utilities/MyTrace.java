package utilities;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyTrace {

    public static void trace(String sMessage)
    {
        System.out.println( sMessage );
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
