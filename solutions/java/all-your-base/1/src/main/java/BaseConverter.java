import java.util.*;
class BaseConverter {

    private int originalBase;
    private int[] originalDigits;
    private int[] convertedDigits;
    BaseConverter(int originalBase, int[] originalDigits) {
        if(originalBase == 1 || originalBase <= 0)
            throw new IllegalArgumentException("Bases must be at least 2.");
        for(int x: originalDigits){
            if(x < 0)
                throw new IllegalArgumentException("Digits may not be negative.");
            if(x >= originalBase)
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
        }
        this.originalBase = originalBase;
        this.originalDigits = originalDigits;
    }

    int[] convertToBase(int newBase) {
        if(newBase == 1 || newBase <= 0)
            throw new IllegalArgumentException("Bases must be at least 2.");
        
        // convert number to decimal
        int decimalNumber = 0; int powerIndex=0;
        for(int index = originalDigits.length -1; index >= 0; index --, powerIndex++){
            decimalNumber += originalDigits[index] * (int)Math.pow(originalBase, powerIndex);
        }

        if(decimalNumber == 0)
            return new int[]{0};


        List<Integer> newNumber = new ArrayList<>();
        int index = 0;
        while(decimalNumber!=0){
            int remainder = decimalNumber % newBase;
            newNumber.add(remainder);
            decimalNumber /= newBase;
        }
        Collections.reverse(newNumber);
        convertedDigits = newNumber.stream()
                                    .mapToInt(Integer::intValue)
                                    .toArray();
        return convertedDigits;
    }

}