package newcoder.offer;

public class FindminnumberInRotateArray11 {
    public int minNumberInRotateArray(int [] array) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < res){
                res = array[i];
            }
        }
        return res;

    }
    public int minNumberInRotateArray1(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0, h = array.length-1;
        while (l < h) {
            int m = l+(h-l)/2;
            if (array[m] <= array[h]) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return array[l];

    }

    public int minNumberInRotateArray3(int[] array) {
        if (array.length == 0)
            return 0;
        int l = 0, h = array.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (array[l] == array[m] && array[m] == array[h])
                return minNumber(array, l, h);
            else if (array[m] <= array[h])
                h = m;
            else
                l = m + 1;
        }
        return array[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }

}
