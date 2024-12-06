package DynamicProgramming.LongestCommonSubsequnce;

public class P07_MinimumNumberOfDeletionsToMakeAStringPalindrome {
    public static void main(String[] args) {
        String a = "agbcba";
        int ans = helper(a);
        System.out.println(ans);
    }

    private static int helper(String a) {
        StringBuilder sb = new StringBuilder();
        for(int i = a.length()-1; i>=0; i--){
            sb.append(a.charAt(i));
        }
        String b = sb.toString();
        return lcs(a,b);
    }

    private static int lcs(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return a.length() - dp[n1][n2];
    }
}
