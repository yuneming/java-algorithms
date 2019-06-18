package newcoder.offer;

import java.util.Arrays;

public class Fibonacci10by4 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        //Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];

    }
    public int JumpFloorII1(int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++){
            dp[i] = 0;
            for (int j = 0; j < i; j++){
                dp[i] += dp[j];
            }
        }
        return dp[target];


    }
}
