package newcoder.offer;

public class RobotMoveRange13 {
    private int count = 0;
    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cols;
    private int rows;
    private int threshold;
    private int[][] digitSum;
    public int movingCount(int threshold, int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked,0,0);
        return count;

    }
    private void dfs(boolean[][] marked,int r, int c){
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) return;
        marked[r][c] = true;
        if (this.digitSum[r][c] > this.threshold) return;
        count++;
        for (int[] n : next){
            dfs(marked,r+n[0],c+n[1]);
        }

    }
    private void initDigitSum(){
        int[] digitSumOne = new int[Math.max(rows,cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n >0) {
                digitSumOne[i] += n%10;
                n /=10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++)
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
    }
}
