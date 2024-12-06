package DynamicProgramming.LongestCommonSubsequnce;

public class P03_PrintLCS {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        String lcs = topDown(s1,s2);
        System.out.println(lcs);
    }

    private static String topDown(String s1, String s2) {
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
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n1;
        int j = n2;
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                if(sb.isEmpty()){
                    sb.append(s1.charAt(i-1));
                }else{
                    sb.insert(0,s1.charAt(i-1));
                }
                i--;
                j--;
            }else if(dp[i][j-1] > dp[i-1][j]){
                j--;
            }else{
                i--;
            }
        }
        return sb.toString();
    }
}
