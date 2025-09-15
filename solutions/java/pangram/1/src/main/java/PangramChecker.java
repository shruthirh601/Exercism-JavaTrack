import java.util.*;
public class PangramChecker {

    public boolean isPangram(String input) {
        input = input.toLowerCase();
        input = input.replaceAll("[^a-z]",""); 
        input = input.replaceAll("(.)(?=.*\\1)","");
        return (input.length() == 26)? true: false;
        
    }

}
