package leetcode;

public class RemoveDuplicatedFromSortedArrayII {
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int removeDuplicates(int[] nums){
        int pointer = 0;
        // 统计重复项
        int count = 1;
        if(nums.length<=2) {return nums.length;}
        for(int i = 1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                count++;
            }else {
                count=1;
            }
            if(count<=2){
                pointer++;
                nums[pointer]=nums[i];
            }


        }
        System.out.println(pointer);
        printArray(nums);
        return pointer+1;
    }
    public static void main(String[] args){
        int[] testArray={0,0,1,1,1,2,3,3};

        printArray(testArray);
        removeDuplicates(testArray);


    }
}
