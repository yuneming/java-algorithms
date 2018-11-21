package leetcode;

import java.util.HashMap;

/**
 * leetcode 1
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> record = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            int complement = target-nums[i];
            if (record.containsKey(complement)){
                int[] res = {i,record.get(complement)};
                return res;
            }
            record.put(nums[i],i);
        }
        throw new IllegalStateException("the input has no solution");
    }
}
