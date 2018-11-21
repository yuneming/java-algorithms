package leetcode;

import java.util.*;

/**
 * leetcode 15
 */
public class ThreeSum {
    /**
     * 运行会超时
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length-1;i++){
            for (int j = i+1; j < nums.length;j++){
                int temp1 = nums[i],temp2 = nums[j];
                int complement = 0-temp1-temp2;
                if (record.containsKey(complement)){
                    List<Integer> res = null;
                    if (temp1 < temp2){
                        int temp = temp1;
                        temp1 = temp2;
                        temp2 = temp;
                    }
                    if (complement > temp1){
                        res= Arrays.asList(new Integer[]{temp2,temp1,complement});
                    }
                    else if (complement > temp2){
                        res= Arrays.asList(new Integer[]{temp2,complement,temp1});
                    }
                    else {
                        res= Arrays.asList(new Integer[]{complement,temp2,temp1});
                    }

                    if (!result.contains(res)){
                        result.add(res);
                    }

                }

            }
            record.put(nums[i],i);


        }
        return result;

    }

    /**
     * 使用HashMap来保存数字和出现的次数
     */
    public static List<List<Integer>> threeSumII(int[] nums){
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0)+1);
        }
        List<List<Integer>> allList = new ArrayList<>();
        for(HashMap.Entry<Integer, Integer> entry: countMap.entrySet()) {
            int v0 = entry.getKey();
            int count0 = entry.getValue();
            // 考虑[a,a,a]这种情况
            if(count0 >= 3) {
                if(v0 == 0) {
                    allList.add(Arrays.asList(0,0,0));
                }
            }
            // 考虑[a,a,b]这种情况
            if(count0 >= 2) {
                int v2 = 0 - v0 * 2;
                if(v2 != v0) {
                    if(countMap.get(v2) != null) {
                        allList.add(Arrays.asList(v0,v0, v2));
                    }
                }
            }
            for(int v1: countMap.keySet()) {
                int v2 = 0 - v1 - v0;
                if(v1 <= v0 || v2 <= v1 || countMap.get(v2) == null) continue;
                allList.add(Arrays.asList(v0, v1, v2));
            }
        }
        return allList;


    }

    /**
     * 通过排序加双指针,需要跳过重复元素，防止集合重复
     */
    public static List<List<Integer>> threeSumIII(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> allList = new ArrayList<>();
        for(int i = 0; i < nums.length; ) {
            int begin = i+1, end = nums.length-1;
            while(begin < end) {
                if(nums[begin] + nums[end] == 0 - nums[i]) {
                    allList.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    begin++;
                    while(nums[begin] == nums[begin-1] && begin < end) {
                        begin++;
                    }
                    end--;
                    while(nums[end] == nums[end+1] && begin < end) {
                        end--;
                    }
                }
                else if(nums[begin] + nums[end] < 0 - nums[i]) {
                    begin++;
                }
                else {
                    end--;
                }
            }

            i++;
            while(i < nums.length && nums[i] == nums[i-1]) {
                i++;
            }
        }
        return allList;
    }
    public static void main(String[] args){
        int[] testArray={-1,0,1,2,-1,-4};
        System.out.println(threeSumIII(testArray));
    }
}
