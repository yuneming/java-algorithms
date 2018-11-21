package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 16
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE-nums[nums.length-1];
        int minSum = 0;
        for(int i = 0; i < nums.length; ) {
            int begin = i+1, end = nums.length-1;
            while(begin < end) {
                if(nums[begin] + nums[end] == target - nums[i]) {
                    return target;

                }
                else if(nums[begin] + nums[end] < target - nums[i]) {
                    int a = Math.abs(nums[begin]+nums[end]+nums[i]-target);
                    int b =  Math.abs(min);
                    if (Math.abs(nums[begin]+nums[end]+nums[i]-target) < Math.abs(min)){
                        min = nums[begin]+nums[end]+nums[i]-target;
                        minSum = nums[begin]+nums[end]+nums[i];
                    }

                    begin++;
                }
                else {
                    if (Math.abs(nums[begin]+nums[end]+nums[i]-target) < Math.abs(min)){
                        min = nums[begin]+nums[end]+nums[i]-target;
                        minSum = nums[begin]+nums[end]+nums[i];
                    }
                    end--;
                }
            }

            i++;
            while(i < nums.length && nums[i] == nums[i-1]) {
                i++;
            }
        }
        return minSum;
    }
    public static void main(String[] args){
        int[] testArray={0,1,2};
        System.out.println(threeSumClosest(testArray,3));
    }

}
