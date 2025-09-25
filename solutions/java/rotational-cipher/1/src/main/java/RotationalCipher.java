class RotationalCipher {
    
    private int shiftKey;
    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder rotated = new StringBuilder();
        if(shiftKey == 0 || shiftKey == 26)
            return data;

        for(char ch: data.toCharArray()){
            if(Character.isLetter(ch)){
            char base = Character.isUpperCase(ch) ? 'A' : 'a';
            ch = (char)(base + (ch - base + shiftKey) % 26);
            }
            rotated.append(ch);
        }
        return rotated.toString();
    }

}
