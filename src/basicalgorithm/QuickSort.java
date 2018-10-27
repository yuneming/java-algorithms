package basicalgorithm;

import java.util.Arrays;

/**
 * 快速排序，递归树最佳是一个平衡树，大量重复元素个数据有序会退化成n^2级别
 * pivot选择第一个或者最后一个
 * pivot随机化选择一个
 * 二路快速排序，解决大量重复值
 * 三路快速排序，等于pivot的元素较多
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    // 随机快速排序
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 随机选一个数，防止选择的比较值是最差情况，比如1，2，3，4，5，6，选择6为pivot情况很差
            // 不是非得选取最左边或者最右边元素
            // 每一次 partition 都要使左右俩边的元素尽可能均衡，
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        // 小于等于区右边界,定义一个小于pivot的区域，实现O(n)级别的算法
        // 小于区边界的标记
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] { less + 1, more };
    }
    // 二路快速排序，从左右俩边来遍历，存在大量重复元素
    public static int[] partition2(int[] arr,int l, int r){
        int temp = arr[l];
        int i = l+1,j=r;
        while (true){
            while (i<=r && arr[i]<temp){
                i++;
            }
            while (j>=l+1 && arr[j]>temp){
                j--;
            }
            if (i > j){
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return new int[] { i+1, j };

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
