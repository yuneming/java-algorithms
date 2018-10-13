package leetcode;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int pointer = 0 ;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[pointer]=nums[i];
                pointer++;
            }

        }

        for(int i=pointer;i<nums.length;i++){
            nums[i] = val;
        }
        printArray(nums);
        System.out.println(pointer);
        return pointer;
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
        int[] testArray={0,1,2,2,3,0,4,2};
        int val = 2;
        printArray(testArray);
        removeElement(testArray,val);


    }
}
