package DynamicProgramming.LongestCommonSubsequnce;

import static DynamicProgramming.LongestCommonSubsequnce.P06_LongestPalindromicSubsequnce.helper;

public class P11_MinNumberOfInsertionsToMakeStringPalindrome {
    public static void main(String[] args) {
        String s = "aebcbda";
        int lenLPS = helper(s);
        System.out.println(s.length() - lenLPS);
    }
}
