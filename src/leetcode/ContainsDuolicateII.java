package leetcode;

import java.util.HashSet;

/**
 * leetcode 219
 */
public class ContainsDuolicateII {
    /**
     * 使用查找表和滑动窗口的思想
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1){
            return false;
        }
        if (k <= 0){
            return false;
        }
        HashSet<Integer> record = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (record.contains(nums[i])){
                return true;
            }
            record.add(nums[i]);
            // 维护一个k+1大小的滑动窗口
            if (record.size() == k+1){
                record.remove(nums[i-k]);
            }
        }
        return false;
    }
}
