package utilities;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

public class MyTrace {

    public static void trace(SelenideElement element, String sMessage )
    {
        String sPrintMessage = sMessage + " " + element.getTagName();
        System.out.println( sPrintMessage );
    }

    public static void trace(SelenideElement element, String sMessage, Exception e )
    {
        String sPrintMessage = sMessage + " " + element.getTagName() + " " + e.getMessage();
        System.out.println( sPrintMessage );
    }

}
