import java.util.regex.*;  

class LargestSeriesProductCalculator {
    int[] arr;
    String s;
    LargestSeriesProductCalculator(String inputNumber) throws IllegalArgumentException{
        s = inputNumber;
        if(Pattern.matches(".*[^0-9]+.*",s)){throw new IllegalArgumentException("String to search may only contain digits.");}
    }

    long calculateLargestProductForSeriesLength (int numberOfDigits) throws IllegalArgumentException  {
        long larg=0;
        String[] spl;

        if(numberOfDigits<0){
            throw new IllegalArgumentException("Series length must be non-negative.");
        }else if(numberOfDigits==0){
            return 1;
        }
        if(s.length()<numberOfDigits){throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");}
        
        
        spl = s.split("0", 0);
        for(String splx:spl){
            char[] c = splx.toCharArray();
            int[] arr;
            if(c.length<numberOfDigits){continue;}
            arr = new int[c.length]; 
            for(int i=0; i<c.length; i++){
                arr[i]=(int) c[i] - (int) '0';
            }
            long out=1;
            for(int i=0; i<numberOfDigits; i++){
                out*=arr[i];
            }
            if(larg<out){
                larg=out;
            }
            for(int i=numberOfDigits; i<c.length; i++){
                out = out*arr[i];
                out = out/arr[i-numberOfDigits];
                if(larg<out){
                    larg=out;
                }
            }

        }

        return larg;

    }
}