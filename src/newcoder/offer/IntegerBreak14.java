package newcoder.offer;

public class IntegerBreak14 {
    // 贪心算法
    public int integerBreak(int n) {
        if (n < 2){
            return 0;
        }
        if (n==2) {
            return 1;
        }
        if (n==3) {
            return 2;
        }
        int timesOf3 = n/3;
        // 如果余数是1，就可以把1和最后一个3合并成4
        if (n-timesOf3*3 == 1){
            timesOf3--;
        }
        int timeOf2 = (n-timesOf3*3)/2;
        return (int)(Math.pow(3,timesOf3) * (int)(Math.pow(2,timeOf2)));
    }
    // 动态规划
    public int integerBreak1(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }
    // 动态规划
    public int integerBreak2(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // 创建数组存储子问题最优解
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] =3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int temp = dp[j]*dp[i-j];
                if (max < temp)
                    {
                        max = temp;
                    }
            }
            dp[i] = max;
        }
        return dp[n];
    }



}
