package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j {

    //Initialize Log4j instance
    private static Logger Log = Logger.getLogger(Log4j.class.getName());

    public static void log4jSetup(){
        String log4jConfPath = System.getProperty("user.dir")+"//Properties//log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    public static void startLog (String testClassName) {
        Log.info("Test is Starting...");
    }

    public static void endLog (String testClassName){

        Log.info("Test is Ending...");
    }

    public static void info (String message) {

        Log.info(message);
    }

}
