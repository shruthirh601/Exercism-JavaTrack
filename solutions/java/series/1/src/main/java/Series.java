import java.util.*;

class Series {

    private String string;

    Series(String string) {
        this.string = string;
        if(string.equals(""))
            throw new IllegalArgumentException("series cannot be empty");
    }

    List<String> slices(int num) {
        if (num > string.length())
            throw new IllegalArgumentException("slice length cannot be greater than series length");

        if(num <= 0)
            throw new IllegalArgumentException("slice length cannot be negative or zero");
        
        List<String> substrings = new ArrayList<>();

        for (int i = 0; i <= string.length() - num; i++) {
            substrings.add(string.substring(i, i + num));
        }

        return substrings;
    }
}