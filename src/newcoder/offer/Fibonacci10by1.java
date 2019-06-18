package newcoder.offer;

public class Fibonacci10by1 {
    public int Fibonacci(int n) {
        if (n==0 || n==1){
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public int Fibonacci1(int n) {
       if (n <= 1) {
           return n;
       }
       int[] fib = new int[n+1];
       fib[1] = 1;
       for (int i = 2; i <= n; i++){
           fib[i] = fib[i-1]+fib[i-2];
       }
       return fib[n];
    }
    public int Fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++){
            fib = pre2+pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}
