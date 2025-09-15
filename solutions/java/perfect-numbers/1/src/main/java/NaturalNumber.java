class NaturalNumber {
    int sumOfFactors =1;
    Classification result;
    NaturalNumber(int number) {
        if(number ==1){
            result = Classification.DEFICIENT;
            return;
        }
        if(number<=0)
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        for(int i=2; i< number;i++){
            if(number%i==0)
                sumOfFactors+= i;
        }
        if(sumOfFactors == number)
            result = Classification.PERFECT;
        else if(sumOfFactors > number)
            result =Classification.ABUNDANT;
        else
            result =Classification.DEFICIENT;
    }
    

    Classification getClassification() {
        return result;
    }
}
