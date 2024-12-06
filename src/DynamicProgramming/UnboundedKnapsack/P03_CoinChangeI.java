package DynamicProgramming.UnboundedKnapsack;

public class P03_CoinChangeI {
    public static void main(String[] args) {
        int[] coin = {1,2,3};
        int sum = 5;
        int maxWays = topDown(coin,sum,coin.length);
        System.out.println(maxWays);
    }

    private static int recur(int[] coin, int sum, int n) {
        if(n == 0 && sum == 0) return 1;
        if(n == 0) return 0;
        int ans = recur(coin,sum,n-1);
        if(coin[n-1] <= sum){
            ans += recur(coin,sum - coin[n-1],n);
        }
        return ans;
    }
    private static int topDown(int[] coin, int sum, int n){
        int[][] dp = new int[n+1][sum+1];
        for(int j = 0; j <= sum; j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                dp[i][j] = dp[i-1][j];
                if(coin[i-1] <= j){
                    dp[i][j] += dp[i][j - coin[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
