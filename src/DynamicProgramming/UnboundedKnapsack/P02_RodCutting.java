package DynamicProgramming.UnboundedKnapsack;

public class P02_RodCutting {
    public static void main(String[] args) {
        int[] len = {1,2,3,4,5,6,7,8};
        int[] val = {1,5,8,9,10,17,17,20};
        int toLen = 8;
        int maxProfit = topDown(len,val,toLen,len.length);
        System.out.println(maxProfit);
    }

    private static int topDown(int[] len, int[] val, int toLen, int n) {
        int[][] dp = new int[n+1][toLen+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= toLen; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }else if(len[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-len[i-1]] + val[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][toLen];
    }
}
