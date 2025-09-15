import java.util.*;
class IsogramChecker {

    boolean isIsogram(String phrase) {
        boolean isIsogramString = true;
        phrase = phrase.toLowerCase();
        phrase = phrase.replaceAll("[^a-zA-Z]","");
        Map<Character, Integer> letterFreq = new HashMap<>();
        char[] phraseLetters = phrase.toCharArray();
        for(char ch: phraseLetters){
                letterFreq.put(ch, letterFreq.getOrDefault(ch,0)+1);
        }

        for (Map.Entry<Character, Integer> entry : letterFreq.entrySet()) {
            if(entry.getValue() > 1){
                isIsogramString = false;
                break;
            }
        
        }
       return isIsogramString; 
    }

}
