package leetcode;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int pointer = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[pointer]!=nums[i]){
                pointer++;
                nums[pointer]=nums[i];

            }
        }
        System.out.println(pointer);
        printArray(nums);
        return pointer+1;
    }
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] testArray={0,0,1,1,1,2,2,3,3,4};

        printArray(testArray);
        removeDuplicates(testArray);


    }
}
