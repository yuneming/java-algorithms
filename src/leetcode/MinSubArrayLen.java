package leetcode;

/**
 * leetcode 209
 */
public class MinSubArrayLen {
    /**
     * 利用滑动窗口进行子数组的滑动
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0,right = -1;
        int sum = 0;
        int res = nums.length+1;
        while (left < nums.length){
            if (right+1 < nums.length && sum < s){
                sum += nums[++right];

            }
            else {
                sum -= nums[left];
                left++;
            }
            if (sum >= s){
                res = Math.min(res,right-left+1);
            }
        }
        if (res == nums.length+1){
            return 0;
        }
        return res;

    }
    public static void main(String[] args){
        int[] height = {2,3,1,2,4,3};
        int area = minSubArrayLen(7,height);
        System.out.println(area);
    }
}
