package DynamicProgramming.LongestCommonSubsequnce;

import static DynamicProgramming.LongestCommonSubsequnce.P01_LCSBasic.topDown;

public class P10_SquencePatternMatching {
    public static void main(String[] args) {
        String a = "axy";
        String b = "adxcpy";
        int lenLcs = topDown(a,b);
        if(lenLcs == a.length()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
