package DynamicProgramming.ZeroOneKnapsack;

public class P05_MinimizeSubsetSumDiff {
    public static void main(String[] args) {
        int[] arr = {1,2,7};
        int min = helper(arr,arr.length);
        System.out.println(min);
    }

    private static int helper(int[] arr, int n) {
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
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
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sum/2; i++){
            if(dp[n][i]){
                min = Math.min(min,(sum - (2*i)));
            }
        }
        return min;
    }
}
