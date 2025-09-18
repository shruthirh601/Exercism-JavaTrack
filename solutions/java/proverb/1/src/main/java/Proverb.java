class Proverb {
    String finalProverb;
    Proverb(String[] words) {
        if(words.length == 0)
            finalProverb = "";
        else{
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< words.length-1; i++){
            sb.append(String.format("For want of a %s the %s was lost.\n",words[i],words[i+1]));
        }
        sb.append(String.format("And all for the want of a %s.", words[0]));
        finalProverb = sb.toString();
        }
    }

    String recite() {
        return finalProverb;
    }

}
