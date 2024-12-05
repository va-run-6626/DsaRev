package DynamicProgramming.ZeroOneKnapsack;

public class P07_TargetSum {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;
        int ans = find(arr,target, arr.length);
        System.out.println(ans);
    }

    private static int find(int[] arr, int target, int n) {
        int ran = 0;
        for(int i : arr){
            ran += i;
        }
        if((ran - target) % 2 == 1 || target > ran) return 0;
        int sum = (ran - target)/2;
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(arr[i - 1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }
}
