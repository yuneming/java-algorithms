package leetcode;

/**
 * leetcode 215
 */
public class FindKthLargest {
    /**
     * 通过普通的插入排序来找第k大的值
     */
    public static int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length-1; i++){
            for (int j=0; j < nums.length-1;j++){
                if (nums[j]<nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
        return nums[k-1];

    }
    public static int findKthLargestByQuickSelect(int[] nums, int k){
        int left = 0, right = nums.length-1;
        while (true){
            int pos = partition(nums,left,right);
            if (pos == k-1){
                return nums[pos];
            }
            else if(pos > k-1){
                right = pos-1;
            }
            else {
                left = pos+1;
            }

        }
    }
    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l = left+1;
        int r = right;
        while (l <= r){
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums,l, r);
                l++;
                r--;
            }
            if (nums[l] >= pivot) ++l;
            if (nums[r] <= pivot) --r;
        }
        swap(nums,left,r);
        return r;
    }
    private static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }
    public static void main(String[] args){
        int testArray[] = {3,2,1,5,6,4};
        int num = findKthLargestByQuickSelect(testArray,2);
        System.out.println(num);

    }
}
