import java.util.regex.*;
public class LogLevels {
    
    public static String message(String logLine){
    String[] parts = logLine.split("]:\\s*", 2);
    String message="";
    if (parts.length == 2) {
     message = parts[1].trim();     
   
    }
        return message;
    }

    public static String logLevel(String logLine) {
        String[] parts = logLine.split("]:\\s*", 2);
        String level="";
        if (parts.length == 2) {
         level = parts[0].substring(1); 
        
        System.out.println("Level: " + level);
    }
        return level.toLowerCase();
    }

    public static String reformat(String logLine) {
        String[] parts = logLine.split("]:\\s*", 2);
        String result = "";
        String level="";String message= "";
    if (parts.length == 2) {
        level = parts[0].substring(1); 
        message = parts[1].trim();     
        System.out.println("Level: " + level);
        System.out.println("Message: " + message);
    }
        result = String.format("%s (%s)", message, level.toLowerCase());
        return result;
    }
}
