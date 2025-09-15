public class EliudsEggs {
    public int eggCount(int number) {
        int onesCount = 0;
        String binaryString = Integer.toBinaryString(number);
        char[] binaryStringArray = binaryString.toCharArray();
        for(char ch: binaryStringArray){
            if(ch == '1')
                onesCount++;
        }
       return onesCount; 
    }
}
