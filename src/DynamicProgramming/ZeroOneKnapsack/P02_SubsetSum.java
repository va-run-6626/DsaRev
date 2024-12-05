package DynamicProgramming.ZeroOneKnapsack;

import java.util.Arrays;

public class P02_SubsetSum {
    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10};
        int sum = 11;
        int[][] memo = new int[sum+1][arr.length+1];
        for(int[] ar : memo){
            Arrays.fill(ar,-1);
        }
        boolean exists = topDown(arr,sum,arr.length);
        System.out.println(exists);
    }

    private static int memo(int[] arr, int sum, int n, int[][] memo) {
        if(n == 0 && sum != 0){
            return 0;
        }
        if(n == 0 && sum == 0){
            return 1;
        }
        if(memo[sum][n] != -1) return memo[sum][n];
        if(arr[n-1] <= sum){
            return memo(arr,sum-arr[n-1],n-1,memo) + memo(arr,sum,n-1,memo);
        }
        return memo(arr,sum,n-1,memo);
    }

    static boolean topDown(int[] arr, int sum, int n){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int j = 0; j <= sum; j++){
            dp[0][j] = false;
        }
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    private static boolean recur(int[] arr, int sum, int n) {
        if(n == 0 && sum != 0){
            return false;
        }
        if(n == 0 && sum == 0){
            return true;
        }
        if(arr[n-1] <= sum){
            return recur(arr,sum-arr[n-1],n-1) || recur(arr,sum,n-1);
        }
        return recur(arr,sum,n-1);
    }
}
