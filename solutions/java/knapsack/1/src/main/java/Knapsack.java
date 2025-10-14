import java.util.List;

class Knapsack {

    int maximumValue(int maximumWeight, List<Item> items) {
        int w = maximumWeight;
        int n= items.size();
        int dp[][] = new int[n+1][w+1];
        for (int i = 0; i < n+1; i++)
            for (int j = 0; j < w+1; j++)
                dp[i][j] =-1;

        return knapsackRec(w, items, n, dp);
    }

    private int knapsackRec(int w, List<Item> items, int n, int[][] dp) {
        if(n==0 || w==0)
            return 0;
        if(dp[n][w]!=-1)
            return dp[n][w];

        if(items.get(n-1).weight > w)
            return dp[n][w] = knapsackRec(w, items,n - 1, dp);
        else
            return dp[n][w] = max((items.get(n-1).value + knapsackRec(w - items.get(n-1).weight, items, n - 1, dp)), knapsackRec(w, items, n - 1, dp));
    }

    static int max(int a, int b){
        return a>b?a:b;
    }

}