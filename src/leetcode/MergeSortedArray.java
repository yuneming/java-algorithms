package leetcode;

/**
 * LeetCode 88
 */
public class MergeSortedArray {
    /**
     * 普通能想到的方法
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArr =new int[m+n];
        int j = 0;
        int k = 0;
        for (int i = 0; i< m+n;i++){
           if (j <m && k < n &&  nums1[j] <= nums2[k] ){
                tempArr[i] = nums1[j];
                j++;
            }
            else if (j <m && k < n && nums1[j] > nums2[k] ){
                tempArr[i] = nums2[k];
                k++;
            }

            else if (j>=m && k < n){
                tempArr[i] = nums2[k];
                k++;
            }
            else if (j<m && k >= n){
                tempArr[i] = nums1[j];
                j++;
            }
        }
        for (int i = 0;i < m+n;i++){
            nums1[i] = tempArr[i];
        }


    }
    public static void mergeII(int[] nums1, int m, int[] nums2, int n){
        int count = m+n-1;
        int i = m-1, j = n-1;
        while (i >=0 && j >=0){
            if (nums1[i] >= nums2[j]){
                nums1[count] = nums1[i];
                count--;
                i--;
            }
            else if (nums1[i] < nums2[j]){
                nums1[count] = nums2[j];
                count--;
                j--;
            }
        }
        while (i>=0){
            nums1[count] = nums1[i];
            count--;
            i--;
        }
        while (j >=0){
            nums1[count] = nums2[j];
            count--;
            j--;
        }
    }
    public static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] num1 = {1};
        int[] num2 = {};
        mergeII(num1,1,num2,0);
        printArr(num1);


    }
}
