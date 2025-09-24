import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Anagram {
    private String word;
    private String sortedWord;

    public Anagram(String word) {
        this.word = word;
        this.sortedWord = sortChars(word.toLowerCase());
    }

    public List<String> match(List<String> candidates) {
        List<String> anagrams = new ArrayList<>();
        for (String candidate : candidates) {
            if (candidate.equalsIgnoreCase(word)) {
                continue;
            }
            if (sortChars(candidate.toLowerCase()).equals(sortedWord)) {
                anagrams.add(candidate);
            }
        }
        return anagrams;
    }

    private String sortChars(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}