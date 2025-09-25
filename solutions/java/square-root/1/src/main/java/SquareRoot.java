public class SquareRoot {

    
    public int squareRoot(int radicand) {
        if(radicand == 0)
            return 0;
        if(radicand == 1)
            return 1;

        int low = 1;
        int high = radicand;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == radicand) {
                return mid;
            } else if (mid * mid < radicand) {
                ans = mid;
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
