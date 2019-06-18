package newcoder.offer;

public class ReOrderArray21 {
    public void reOrderArray(int[] nums) {
        //奇数个数
        int oddCnt = 0;
        for (int x:nums) {
            if (!isEven(x)) {
                oddCnt++;
            }
        }
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num:copy){
            if (num %2 == 1){
                nums[i++] = num;
            }else {
                nums[j++] = num;
            }
        }
    }
    private boolean isEven(int x) {
        return x % 2 == 0;
    }
}
