package DynamicProgramming.LongestCommonSubsequnce;

public class P05_MinimumNumOfInsertionsAndDeletions {
    public static void main(String[] args) {
        String a = "geeks";
        String b = "geeksforgeeks";
        int ans = recur(a,b,0,0);
        System.out.println(ans);
    }

    private static int recur(String a, String b, int i, int j) {
        if(i == a.length()){
            return b.length() - j;
        }
        if(j == b.length()){
            return a.length() - i;
        }
        if(a.charAt(i) == b.charAt(j)){
            return recur(a,b,i+1,j+1);
        }
        int insert = recur(a,b,i,j+1);
        int delete = recur(a,b,i+1,j);
        return 1+Math.min(insert,delete);
    }
    private static int topDown(String a , String b){
        int n1 = a.length();
        int n2 = b.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 0; i <= n1; i++){
            for(int j = 0; j <= n2; j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j],dp[j-1][i]);
                }
            }
        }
        return dp[n1][n2];
    }
}
