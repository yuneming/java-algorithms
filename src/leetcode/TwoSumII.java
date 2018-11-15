package leetcode;

/**
 * leetcode 167
 */
public class TwoSumII {
    // 暴力破解，双层遍历，leetcode也能过
    public static int[] twoSum(int [] numbers, int target){
        int[] index = new int[2];
        for (int i = 0; i < numbers.length;i++){
            for (int j = i+1; j < numbers.length;j++){
                if (numbers[i]+numbers[j] == target){
                    index[0] = i+1;
                    index[1] = j+1;
                }
            }
        }
        return index;
    }

    /**
     * 利用二分查找去找有序数组后面一部分，时间复杂度为O(nlogn)
     */
    public static int[] twoSumII(int[] numbers, int target){
        int[] index = new int[2];
        for (int i = 0; i < numbers.length; i++){
            int left = i+1;
            int right = numbers.length-1;
            while (left <= right){
                // 防止整型溢出
                int mid = left+(right-left)/2;
                if(numbers[i]+numbers[mid] == target ){
                    index[0] = i+1;
                    index[1] = mid+1;
                }
                if(numbers[i]+numbers[mid] < target){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }

            }
        }
        return index;
    }

    /**
     * 利用对撞指针来实现O(n)级别的算法
     */
    public static int[] twoSumIII(int[] numbers, int target){
        int[] index = new int[2];
        int left = 0,right = numbers.length-1;
        while (left < right){
            if (numbers[left]+numbers[right] == target){
                index[0] = left+1;
                index[1] = right+1;
                break;
            }
            else if (numbers[left]+numbers[right] < target){
                left++;
            }
            else if (numbers[left]+numbers[right] > target){
                right--;
            }
        }
        return index;
    }
    public static void main(String[] args){
        int testArray[] = {2,7,11,15};
        int[] num = twoSumIII(testArray,9);
        System.out.println(num[1]);
    }
}
