package DynamicProgramming.ZeroOneKnapsack;

import java.util.Arrays;

public class P01_ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = {2,7,4,9};
        int[] val = {9,6,7,4};
        int w = 13;
        int[][] memo = new int[wt.length+1][w+1];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        int ans = topDown(wt,val,w,wt.length);
        System.out.println(ans);
    }

    private static int recursive(int[] wt, int[] val, int w, int n) {
        if(n == 0 || w == 0) return 0;
        if(wt[n-1] < w){
            return Math.max(val[n-1] + recursive(wt,val,w-wt[n-1],n-1),recursive(wt,val,w,n-1));
        }else{
            return recursive(wt,val,w,n-1);
        }
    }
    private static int memo(int[] wt, int[] val, int w, int n,int[][] memo) {
        if(n == 0 || w == 0) return 0;
        if(memo[n][w] != -1){
            return memo[n][w];
        }
        if(wt[n-1] < w){
            memo[n][w] = Math.max(val[n-1] + memo(wt,val,w-wt[n-1],n-1,memo),memo(wt,val,w,n-1,memo));
        }else{
            memo[n][w] = memo(wt,val,w,n-1,memo);
        }
        return memo[n][w];
    }
    private static int topDown(int[] wt, int[] val, int w, int n){
        int[][] dp = new int[n+1][w+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= w; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= w; j++) {
                if (wt[i - 1] < j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

}
