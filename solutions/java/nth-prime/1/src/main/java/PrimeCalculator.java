class PrimeCalculator {

    int nth(int nth) {
        if(nth == 0)
            throw new IllegalArgumentException();
        int count = 0, num = 1;
        while(count < nth){
            num++;
            if(this.isPrime(num))
                count++;
        }
        return num;
    }

    static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        if (n == 2) { 
            return true;
        }
        if (n % 2 == 0) { 
            return false;
        }
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    }

