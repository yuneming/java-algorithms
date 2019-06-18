package newcoder.offer;

import java.util.ArrayList;

public class FindLeastKNumbers40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return ret;
        }
        findKthSmallest(input,k-1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;

    }

    private void findKthSmallest(int[] input, int k) {
        int left = 0, h = input.length-1;
        while (left < h){
            int j= partition(input,left,h);
            if (j == k) {
                break;
            }
            if (j > k) {
                h = j-1;
            }else {
                left = j+1;
            }
        }
    }
    private int partition(int[] nums, int l, int h) {
        // 切分元素
        int p = nums[l];
        int i = l, j = h+1;
        while (true) {
            while (i != h && nums[++i] < p);
            while (j != l && nums[--j] > p) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
