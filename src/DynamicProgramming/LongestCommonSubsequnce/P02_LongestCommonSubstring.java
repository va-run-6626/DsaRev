package DynamicProgramming.LongestCommonSubsequnce;

public class P02_LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        int longSubstring = topDown(s1,s2);
        System.out.println(longSubstring);
    }

    private static int recur(String s1, String s2, int i, int j, int res) {
        if(i == 0 || j == 0) return res;
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return recur(s1,s2,i-1,j-1,res+1);
        }
        res = Math.max(res,Math.max(recur(s1,s2,i,j-1,0),recur(s1,s2,i-1,j,0)));
        return res;
    }
    private static int topDown(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
