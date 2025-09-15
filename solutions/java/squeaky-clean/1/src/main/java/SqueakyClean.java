class SqueakyClean {
    static String clean(String identifier) {
        String result="";
        for(int i=0; i<identifier.length(); i++){
            char c=identifier.charAt(i);
            if(Character.isAlphabetic(c))
                result += c;
            if(c==' ')
                result += "_";
            if(c=='-'){
                char c2 = identifier.charAt(i+1);
                result += Character.toUpperCase(c2);
                i++;
            }
            if(Character.isDigit(c)){
                switch(c){
                    case '3': result += 'e';
                        break;
                    case '4': result += 'a';
                        break;
                    case '0': result += 'o';
                        break;
                    case '1': result += 'l';
                        break;
                    case '7': result += 't';
                        break;
                }
            }
            }
        
        return result;
    }
}
