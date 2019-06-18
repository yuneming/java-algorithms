package newcoder.offer;

public class SumWithoutAny64 {
    public int Sum_Solution(int n) {
        int sum = n;
        // n > 0是程序出口
        boolean t = (n > 0) && (sum += Sum_Solution(n-1))>0;
        return sum;
    }
}
