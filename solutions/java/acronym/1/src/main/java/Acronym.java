import java.util.*;
class Acronym {
    private String result ="";
    char[] separators = {' ','-','_'};
    Acronym(String phrase) {
        char[] charArray = phrase.toCharArray();
        for(int i=0; i<charArray.length; i++){
            if(i==0 || this.isAcronymLetter(charArray[i], charArray[i-1]))
                result += Character.toUpperCase(charArray[i]);
        }        
    }

    boolean isAcronymLetter(char current, char previous){
        return (Character.isLetter(current)&&(this.isSeparator(previous) || (Character.isUpperCase(current)&& Character.isLowerCase(previous))));
    }

    boolean isSeparator(char ch){
        for(char x: separators){
            if(ch == x)
                return true;
        }
        return false;
    }
    String get() {
        return result;
    }

}
