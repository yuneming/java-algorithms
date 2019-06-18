package newcoder.offer;

public class FindMostGiftValue47 {
    public int getMost(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return 0;
        int n = board[0].length;
        int[] dp = new int[n];
        for (int[] value : board) {
            dp[0] += value[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i],dp[i-1])+value[i];
            }
        }
        return dp[n-1];
    }
    public int getMost1(int[][] board) {
        int n = board.length;
        int[][] dp = new int[n][n];
        dp[0][0] = board[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1]+board[0][i];
            dp[i][0] =dp[i-1][0]+board[i][0];

        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
            }
        }
        return dp[n - 1][n - 1];
    }
}
