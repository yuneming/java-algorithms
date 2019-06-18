package newcoder.leetcodeCS.twopoint;

public class SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = c;
        while (left <= right) {
            if ((left*left + right*right) == c ) {
                return true;
            } else if ((left*left + right*right) < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
