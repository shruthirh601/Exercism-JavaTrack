public class Hamming {
    private int hammingDistance = 0;
    public Hamming(String leftStrand, String rightStrand) {
        char[] strand1 = leftStrand.toCharArray();
        char[] strand2 = rightStrand.toCharArray();
        if(strand1.length != strand2.length)
            throw new IllegalArgumentException("strands must be of equal length");
        else{
           for(int index = 0; index< strand1.length; index++)
               {
                   if(strand1[index] != strand2[index])
                       hammingDistance++;
               }
        }
    }

    public int getHammingDistance() {
        return hammingDistance;
    }
}
