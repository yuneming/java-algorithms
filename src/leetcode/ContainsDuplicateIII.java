package leetcode;

import java.util.TreeSet;

/**
 * leetcode 220
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long long
        // 使用二叉搜索树是因为需要利用二叉搜索树的顺序性
        TreeSet<Long> record = new TreeSet<Long>();
        for(int i = 0 ; i < nums.length ; i ++){

            if(record.ceiling((long)nums[i] - (long)t) != null &&
                    record.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t)
                return true;

            record.add((long)nums[i]);
            // 滑动窗口保持i和j的坐标不超过给定的整数k
            if(record.size() == k + 1)
                record.remove((long)nums[i-k]);
        }

        return false;
    }
}
