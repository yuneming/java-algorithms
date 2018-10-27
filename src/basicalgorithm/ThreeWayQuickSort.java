package basicalgorithm;

import java.util.Arrays;

public class ThreeWayQuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * @param arr
     * @param l
     * @param r
     * 二路快速排序，避免大量重复元素
     */

    public static void quickSort(int[] arr, int l, int r) {
        if(l < r){
//            int pivot[] = partition(arr,l,r);
//            quickSort(arr,l,pivot[0]-1);
//            quickSort(arr,pivot[1]+1,r);
            int[] pivot = partition2(arr,l,r);
            quickSort(arr,l,pivot[0]);
            quickSort(arr,pivot[1],r);

        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        if (l >= r) {
            return new int[]{0,0};
        }
        //  左右游标的基础上，再增加了一个游标i，用于处理和基准元素相同的元素，也就是将数组分为三部分：小于当前切分元素的部分，等于当前切分元素的部分，大于当前切分元素的部分
        int lt = l, gt = r, i = l + 1;
        int pivot = arr[l];
        while (i <= gt) {
            if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else if (arr[i] < pivot) {
                swap(arr, i++, lt++);
            } else {
                i++;
            }
        }
        return new int[]{lt, gt};

    }
    // 另一种partition的操作方式
    public static int[] partition2(int[] arr, int l, int r){
        int v=arr[l];
        int lt=l; //arr[left+1 …… lt]<v
        int gt=r+1;     //arr[gt …… right] >v
        int i=l+1; //arr[lt+1 …… i) ==v
        while (i < gt){
            if(arr[i] < v){
                swap(arr, i, lt+1);
                i++;
                lt++;
            }
            else if(arr[i]>v){
                swap(arr, i, gt-1);

                gt--;
            }
            else {
                i++;
            }
        }
        swap(arr, l, lt);
        return new int[]{lt-1,gt};
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }
}
