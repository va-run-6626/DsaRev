package DynamicProgramming.LongestCommonSubsequnce;

public class P08_ShortestCommonSupersequncePrint {
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int findLen = recur(a,b,a.length(),b.length());
        String seq  = findSeq(a,b);
        System.out.println(seq);
    }

    private static int recur(String a, String b, int i, int j) {
        if(i == 0) return j;
        if(j == 0) return i;
        if(a.charAt(i-1) == b.charAt(j-1)) return 1 + recur(a,b,i-1,j-1);
        else return 1 + Math.min(recur(a,b,i,j-1),recur(a,b,i-1,j));
    }

    private static String findSeq(String a, String b){
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
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n1;
        int j = n2;
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                if(sb.isEmpty()){
                    sb.append(a.charAt(i-1));
                }else{
                    sb.insert(0,a.charAt(i-1));
                }
                i--;
                j--;
            }else if(dp[i][j-1] > dp[i-1][j]){
                if(sb.isEmpty()){
                    sb.append(a.charAt(i-1));
                }else{
                    sb.insert(0,a.charAt(i-1));
                }
                i--;
            }else{
                if(sb.isEmpty()){
                    sb.append(b.charAt(j-1));
                }else{
                    sb.insert(0,b.charAt(j-1));
                }
                j--;
            }
        }
        while(i > 0){
            sb.insert(0,a.charAt(i-1));
            i--;
        }
        while(j > 0){
            sb.insert(0,b.charAt(j-1));
            j--;
        }
        return sb.toString();
    }
}
