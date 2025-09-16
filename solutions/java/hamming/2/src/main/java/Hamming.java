public class Hamming {
    private int hammingDistance = 0;
    public Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("strands must be of equal length");
        else{
           for(int index = 0; index< leftStrand.length(); index++)
               { 
                   if(leftStrand.charAt(index) != rightStrand.charAt((index)))
                       hammingDistance++;
               }
        }
    }

    public int getHammingDistance() {
        return hammingDistance;
    }
}
