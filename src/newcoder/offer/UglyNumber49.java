package newcoder.offer;

public class UglyNumber49 {
    // 直接找因数的方法
    public int GetUglyNumber_Solution(int index) {
        int cnt = 0;
        int number = 1;
        while (true) {
            if (isUgly(number)){
                cnt++;
            }
            if (cnt == index) {
                return number;
            }else {
                number++;
            }
        }
    }
    private boolean isUgly(int number) {
        // 判断数能否被2整除
        while (number % 2 == 0) {
            number = number / 2;
        }
        // 判断数能否被2整除
        while (number % 3 == 0) {
            number = number / 3;
        }
        while (number % 5 == 0) {
            number = number / 5;
        }
        if (number == 1) {
            return true;
        }else {
            return false;
        }

    }

    public int GetUglyNumber_Solution1(int index) {
        if (index <= 6) {
            return index;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2,Math.min(next3,next5));
            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }
        return dp[index-1];

    }
}
