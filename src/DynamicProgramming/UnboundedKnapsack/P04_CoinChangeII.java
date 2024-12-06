package DynamicProgramming.UnboundedKnapsack;

import java.util.Arrays;

public class P04_CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int sum = 11;
        int minCoins = topDown(coins, sum);
        System.out.println(minCoins);
    }

    private static int recur(int[] coins, int sum) {
        if(sum == 0) return 0;
        if(sum < 0) return Integer.MAX_VALUE;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int ans = recur(coins, sum - coins[i]);
            if(ans != Integer.MAX_VALUE) {
                minCount = Math.min(minCount, ans+1);
            }
        }
        return minCount;
    }
    private static int topDown(int[] coins, int sum){
        int[] dp = new int[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        return (dp[sum] == Integer.MAX_VALUE) ? -1 : dp[sum];
    }

}
