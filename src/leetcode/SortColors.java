package leetcode;

/**
 * LeetCode 75
 */
public class SortColors {
    // 通过计数排序解决问题
    public static void sortColors(int[] nums){
        // 存放0，1，2三个元素
        int [] count = {0,0,0};
        for (int i = 0; i < nums.length; i++){
            assert nums[i] >=0 && nums[i] <= 2;
            // 类似hash的技巧
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++){
            nums[index++] = 0;
        }
        for(int i = 0 ; i < count[1] ; i ++){
            nums[index++] = 1;
        }
        for(int i = 0 ; i < count[2] ; i ++){
            nums[index++] = 2;
        }

    }

    /**
     * 利用三路快排的思想
     * 对数组只遍历一遍
     * 时间复杂度为O(n),空间复杂度为O(1)
     */
    public static void sortColorsII(int[] nums){
        //[0,...,zero] ==0
        int zero = -1;
        // [zero,...,n-1] == 2;
        int two = nums.length;
        // 不需要i++操作
        for (int i = 0; i < two; ){
            if (nums[i] == 1){
                i++;
            }
            else if (nums[i] == 2){
                swap(nums,i,--two);

            }
            else if (nums[i] == 0){
                swap(nums,++zero,i);
                i++;

            }
        }

    }
    private static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }
    public static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int testArray[] = {2,0,2,1,1,0};
        sortColorsII(testArray);
        printArr(testArray);

    }

}
