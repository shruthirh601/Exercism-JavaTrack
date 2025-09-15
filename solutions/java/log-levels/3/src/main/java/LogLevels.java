import java.util.regex.*;
public class LogLevels {

    public static String message(String logLine){
    return logLine.split("]:\\s*", 2)[1].trim();
    }

    public static String logLevel(String logLine) {
        return logLine.split("]:\\s*", 2)[0].substring(1).toLowerCase();
    }

    public static String reformat(String logLine) {
        String[] parts = logLine.split("]:\\s*", 2);
        String result = "";
        String level="";String message= "";
        level = parts[0].substring(1);
        message = parts[1].trim();
        result = message + " (" + level.toLowerCase() + ")";
        return result;
    }
}
