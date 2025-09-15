class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int copy= numberToCheck;
        int copy2= copy;
        int numberOfDigits = 0;
        while(numberToCheck != 0){
            int digit = numberToCheck %10;
            numberOfDigits++;
            numberToCheck /= 10;
        }

        System.out.println("No of digits" + numberOfDigits);
        int sum = 0;
        while(copy2!=0){
            int digit = copy2 %10;
            sum = sum + (int)Math.pow(digit,numberOfDigits);
            copy2 /=10;
        }
        return (copy == sum) ? true: false;

        
    }

}
