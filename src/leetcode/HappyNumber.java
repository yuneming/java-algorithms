package leetcode;

import java.util.TreeSet;

/**
 * leetcode 202
 */
public class HappyNumber {
    /**
     * 利用Set去保存一些值，然后判断在不在其中
     */
    public static boolean isHappy(int n) {
        TreeSet<Integer> record = new TreeSet<Integer>();
        int num = n;
        while (happyCal(num) != 1){
            if (record.contains(happyCal(num))){
                return false;
            }
            else {
                record.add(happyCal(num));
            }
            num = happyCal(num);
        }
        return true;
    }
    public static int happyCal(int n){
        int sum = 0;
        while (n > 0){
            int temp = n%10;
            n = n/10;
            sum += temp*temp;

        }
        return sum;

    }
    public static void main(String[] args){
        int re = 1047;
        System.out.println(isHappy(re));
    }

}
