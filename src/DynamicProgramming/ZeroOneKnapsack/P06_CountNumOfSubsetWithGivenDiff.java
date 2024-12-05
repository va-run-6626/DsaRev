package DynamicProgramming.ZeroOneKnapsack;

public class P06_CountNumOfSubsetWithGivenDiff {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int diff = 1;
        int ans = findCount(arr,diff,arr.length);
        System.out.println(ans);
    }

    private static int findCount(int[] arr, int diff, int n) {
        int ran = 0;
        for(int i : arr){
            ran += i;
        }
        int sum = (diff + ran) / 2;
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
