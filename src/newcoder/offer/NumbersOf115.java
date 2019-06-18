package newcoder.offer;

public class NumbersOf115 {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n !=0) {
            cnt++;
            n = n&(n-1);
        }
        return cnt;

    }
}
