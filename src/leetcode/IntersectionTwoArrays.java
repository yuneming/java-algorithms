package leetcode;

import java.util.TreeSet;

/**
 * leetcode 349
 */
public class IntersectionTwoArrays {
    /**
     * 利用set这个数据结构来实现找重复元素
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> record = new TreeSet<Integer>();
        for (int num:nums1){
            record.add(num);
        }
        TreeSet<Integer> resultSet = new TreeSet<Integer>();
        for (int num:nums2){
            if (record.contains(num)){
                resultSet.add(num);
            }
        }
        int[] res = new int[resultSet.size()];
        int index = 0;
        for (Integer num:resultSet){
            res[index++] = num;
        }
        return res;
    }
}
