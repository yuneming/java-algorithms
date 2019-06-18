package newcoder.offer;

public class HasPath12 {
    private final static int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
    private int rows;
    private int cols;
    // 回溯法求解
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (rows == 0 || cols == 0) return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix_build = buildMatrix(matrix);
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix_build, str, marked, 0, i, j)){
                    return true;
                }
            }
        }
        return false;

    }
    private boolean backtracking(char[][] matrix, char[] str,
                                 boolean[][] marked, int pathLen, int r, int c) {
        if (pathLen == str.length) return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]){
            return false;
        }
        marked[r][c] = true;
        for (int [] n:next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        marked[r][c] = false;
        return false;

    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[r][c] = array[idx++];
        return matrix;
    }
}
