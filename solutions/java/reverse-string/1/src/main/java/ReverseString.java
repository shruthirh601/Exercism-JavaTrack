class ReverseString {

    String reverse(String inputString) {
        StringBuilder strbuild = new StringBuilder(inputString);
        strbuild = strbuild.reverse();
        return strbuild.toString();
    }
  
}
