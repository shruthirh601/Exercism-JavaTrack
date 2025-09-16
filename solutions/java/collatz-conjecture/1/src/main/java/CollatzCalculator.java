class CollatzCalculator {
    private int numberOfSteps =0;
    int computeStepCount(int start) {
        if(start<=0)
            throw new IllegalArgumentException("Only positive integers are allowed");
        while(start != 1){
            start = (start % 2 ==0)? start/2 : start*3+1;
            numberOfSteps++;
        }
        return numberOfSteps;
    }

}
