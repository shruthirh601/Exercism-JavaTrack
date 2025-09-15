class Scrabble {
    int finalScore = 0;
    Scrabble(String word) {
        word = word.toUpperCase();
        char[] wordArray = word.toCharArray();
        for(char ch: wordArray){
            switch(ch){
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'L':
                case 'N':
                case 'R':
                case 'S':
                case 'T': finalScore += 1;
                    break;
                case 'D':
                case 'G': finalScore += 2;
                    break;
                case 'B':
                case 'C':
                case 'M':
                case 'P': finalScore += 3;
                    break;
                case 'F':
                case 'H':
                case 'V':
                case 'W':
                case 'Y': finalScore += 4;
                    break;
                case 'K': finalScore += 5;
                    break;
                case 'J':
                case 'X': finalScore += 8;
                    break;
                case 'Q':
                case 'Z': finalScore += 10;
                    break;
                default: break;
            }
        }
    }

    int getScore() {
        return finalScore;
    }

}
