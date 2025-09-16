import java.util.*;

class Sieve {
    private int maxPrime;
    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
      // creation of boolean array
        boolean[] prime = new boolean[maxPrime + 1];
        for (int i = 0; i <= maxPrime; i++) {
            prime[i] = true;
        }
 
        for (int p = 2; p * p <= maxPrime; p++) {
            if (prime[p]) {
                // marking as false
                for (int i = p * p; i <= maxPrime; i += p)
                    prime[i] = false;
            }
        }
 
        // Count number of primes
        int count = 0;
        for (int p = 2; p <= maxPrime; p++) {
            if (prime[p])
                count++;
        }
 
        // Store primes in an array
        List<Integer> res = new ArrayList<>();
        int index = 0;
        for (int p = 2; p <= maxPrime; p++) {
            if (prime[p])
                res.add(index++, p);
        }
 
        return res;
    }
          
}
