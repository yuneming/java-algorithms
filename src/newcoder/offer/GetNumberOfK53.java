package newcoder.offer;

public class GetNumberOfK53 {
    public int GetNumberOfK(int [] array , int k) {
        int first = binarrySearch(array, k);
        int last = binarrySearch(array,k+1);
        return (first == array.length || array[first] != k) ? 0 : last-first;
    }
    private int binarrySearch(int[] nums, int k) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h-l) /2;
            if (nums[m] >= k) {
                h = m;
            }else {
                l = m+1;
            }
        }
        return l;
    }

}
