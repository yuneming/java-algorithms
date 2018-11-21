package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 18
 */
public class FourSum {
    /**
     * 和ThreeSum使用的是同样的方法
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> allList = new ArrayList<>();
        for(int i = 0; i < nums.length; ) {
            for(int j = i+1; j < nums.length; ){
                int begin = j+1, end = nums.length-1;
                while(begin < end) {
                    if(nums[begin] + nums[end] == target - nums[i]-nums[j]) {
                        allList.add(Arrays.asList(nums[i], nums[j],nums[begin], nums[end]));
                        begin++;
                        while(nums[begin] == nums[begin-1] && begin < end) {
                            begin++;
                        }
                        end--;
                        while(nums[end] == nums[end+1] && begin < end) {
                            end--;
                        }
                    }
                    else if(nums[begin] + nums[end] < target - nums[i]-nums[j]) {
                        begin++;
                    }
                    else {
                        end--;
                    }
                }

                j++;
                while(j < nums.length && nums[j] == nums[j-1]) {
                    j++;
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
        int[] testArray={0,0,0,0};
        System.out.println(fourSum(testArray,1));
    }
}
