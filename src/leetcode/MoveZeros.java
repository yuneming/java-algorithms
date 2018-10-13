package leetcode;

/**
 * @author Yune
 */

public class MoveZeros {
    // 需要辅助数组
    public static void moveZeroes(int[] nums) {
        int size = nums.length;
        int nozeroPoint = 0;
        int[] tempList = new int[size];
        for(int i=0;i<size;i++){
            if(nums[i]!=0){
                tempList[nozeroPoint]=nums[i];
                nozeroPoint++;
            }

        }
        for(int j =0;j<size;j++ ){
            if(j<nozeroPoint){
                nums[j] = tempList[j];
            }
            else {
                nums[j] = 0;
            }

        }
        printArray(nums);


    }
    // 原地
    public static  void moveZeroesImproved(int[] nums){
        int size = nums.length;
        int point = 0;
        for(int i=0;i<size;i++){
            // point-[0,point)中保存所有当前遍历过的非0元素
            if(nums[i]!=0){
                // 考虑没有0的情况，不会出现无效移动
                if(i!=point){
                    int temp = nums[point];
                    nums[point] = nums[i];
                    nums[i] = temp;
                    point++;
                }
                else{
                    point++;
                }

            }
        }
        printArray(nums);
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
        int[] testArray={0,1,0,3,12};
        printArray(testArray);
        moveZeroesImproved(testArray);


    }

}
