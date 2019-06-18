package newcoder.leetcodeCS.sort;

import sun.plugin2.message.HeartbeatMessage;

public class KthLargestElementinanArrayPartition {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, h = nums.length-1;
        while (left < h) {
            int j = partition(nums, left, h);
            if (j == k) {
                break;
            } else if (j < k) {
                left = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];

    }
    private int partition(int[] a, int left, int h) {
        int i = left, j = h + 1;
        while (true) {
            while (a[++i] < a[left] && i < h) ;
            while (a[--j] > a[left] && j > left);
            if (i >= j) {
                break;
            }
            swap(a,i,j);
        }
        swap(a, left, j);
        return j;
    }
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
