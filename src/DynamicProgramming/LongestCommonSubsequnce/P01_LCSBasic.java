package DynamicProgramming.LongestCommonSubsequnce;

import java.util.Arrays;

public class P01_LCSBasic {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int lcs = topDown(s1,s2);
        System.out.println(lcs);
    }

    static int topDown(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }

    private static int memo(String s1, String s2, int i, int j) {
        int[][] memo = new int[i+1][j+1];
        for(int[] a : memo){
            Arrays.fill(a,-1);
        }
        return helperMemo(s1,s2,i,j,memo);
    }

    private static int helperMemo(String s1, String s2, int i, int j, int[][] memo) {
        if(i == 0 || j == 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            memo[i][j] = 1 + helperMemo(s1,s2,i-1,j-1,memo);
            return memo[i][j];
        }
        int a = helperMemo(s1,s2,i,j-1,memo);
        int b = helperMemo(s1,s2,i-1,j,memo);
        memo[i][j] = Math.max(a,b);
        return memo[i][j];
    }

    private static int recur(String s1, String s2, int i, int j) {
        if(i == 0 || j == 0) return 0;
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return 1 + recur(s1,s2,i-1,j-1);
        }
        int a = recur(s1,s2,i,j-1);
        int b = recur(s1,s2,i-1,j);
        return Math.max(a,b);
    }

}
