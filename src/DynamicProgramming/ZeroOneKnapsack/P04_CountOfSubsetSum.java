package DynamicProgramming.ZeroOneKnapsack;

import java.util.Arrays;

public class P04_CountOfSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int sum = 10;
        int[][] memo = new int[arr.length+1][sum+1];
        for(int[] a : memo){
            Arrays.fill(a,-1);
        }
        int ans = topDown(arr,sum,arr.length);
        System.out.println(ans);
    }

    private static int memo(int[] arr, int sum, int n, int[][] memo) {
        if(sum == 0) return 1;
        if(n == 0) return 0;
        if(memo[n][sum] != -1){
            return memo[n][sum];
        }
        int count = 0;
        if(arr[n-1] <= sum){
            count += memo(arr,sum - arr[n-1],n-1,memo) + memo(arr,sum,n-1,memo);
        }else{
            count += memo(arr,sum,n-1,memo);
        }
        memo[n][sum] = count;
        return memo[n][sum];
    }

    private static int recur(int[] arr, int sum, int n) {
        if(sum == 0) return 1;
        if(n == 0) return 0;
        int count = 0;
        if(arr[n-1] <= sum){
            count += recur(arr,sum - arr[n-1],n-1) + recur(arr,sum,n-1);
        }else{
            count += recur(arr,sum,n-1);
        }
        return count;
    }
    private static int topDown(int[] arr, int sum, int n){
        int[][] dp = new int[n+1][sum+1];
        for(int j = 0; j <= sum; j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

}
