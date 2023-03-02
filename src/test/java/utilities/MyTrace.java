package utilities;

import org.openqa.selenium.WebElement;

public class MyTrace {


    public static void trace(WebElement element, String sMessage )
    {
        String sPrintMessage = sMessage + " " + element.getTagName();

        System.out.println( sPrintMessage );
    }

    public static void trace(WebElement element, String sMessage, Exception e )
    {
        String sPrintMessage = sMessage + " " + element.getTagName() + " " + e.getStackTrace();

        System.out.println( sPrintMessage );
    }

}
