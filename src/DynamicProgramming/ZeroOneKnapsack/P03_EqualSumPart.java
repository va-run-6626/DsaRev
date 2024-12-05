package DynamicProgramming.ZeroOneKnapsack;

import static DynamicProgramming.ZeroOneKnapsack.P02_SubsetSum.topDown;

public class P03_EqualSumPart {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        boolean ans = helper(arr);
        System.out.println(ans);
    }

    private static boolean helper(int[] arr) {
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        if(sum % 2 == 1) return false;
        return topDown(arr,sum/2,arr.length);
    }
}
