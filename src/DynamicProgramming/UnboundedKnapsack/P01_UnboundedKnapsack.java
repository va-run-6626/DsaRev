package DynamicProgramming.UnboundedKnapsack;

import java.util.Arrays;

public class P01_UnboundedKnapsack {
    public static void main(String[] args) {
         int[] wt = {1,2,3,7};
         int[] val= {4,3,8,9};
         int w = 12;

         int[][] memo = new int[wt.length+1][w+1];
         for(int[] a : memo){
             Arrays.fill(a,-1);
         }
         int maxProfit = topDown(wt,val,w,wt.length);
        System.out.println(maxProfit);
    }

    private static int recur(int[] wt, int[] val, int w, int n) {
        if(w == 0 || n == 0) return 0;
        int np = recur(wt,val,w,n-1);
        int p = 0;
        if(wt[n-1] <= w){
            p = recur(wt,val,w-wt[n-1],n) + val[n-1];
        }
        return Math.max(p,np);
    }
    private static int memo(int[] wt,int[] val, int w, int n,int[][] memo){
        if(w == 0 || n == 0) return 0;
        if(memo[n][w] != -1) return memo[n][w];
        int np = memo(wt,val,w,n-1,memo);
        int p = 0;
        if(wt[n-1] <= w){
            p = memo(wt,val,w-wt[n-1],n,memo) + val[n-1];
        }
        memo[n][w] = Math.max(p,np);
        return memo[n][w];
    }
    private static int topDown(int[] wt, int[] val, int w, int n){
        int[][] dp = new int[n+1][w+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= w; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }else if(wt[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-wt[i-1]] + val[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
