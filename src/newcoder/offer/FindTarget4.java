package newcoder.offer;

public class FindTarget4 {
    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        for ( int i = rows-1,j = 0;j < cols && i >=0;) {
            if (array[i][j] == target){
                return false;
            }
            if (array[i][j] > target){
                i--;
                continue;
            }
            if (array[i][j] < target){
                j++;
                continue;
            }
        }
        return false;

    }
}
