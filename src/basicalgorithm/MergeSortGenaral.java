package basicalgorithm;

import java.util.Arrays;

public class MergeSortGenaral {
    // 递归使用归并排序，对arr[l,...,r]的范围进行排序
    public static void mergeSort(int[] array,int low,int high){
        if (low >= high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);
        // 考虑整体有序的情况，如果整体有序就不需要merge操作了
        if (array[mid]>array[mid+1]){
            merge(array,low,mid,high);
        }



    }
    public static void merge(int[] arr, int low, int mid, int high){
        int[] aux = new int[high-low+1];
        // 辅助空间赋值
        for (int i = low; i <= high; i++){
            aux[i-low] = arr[i];
        }
        int i = low, j = mid+1;
        for (int k = low; k <= high; k++){
            // 左边的已经遍历完
            if (i > mid){
                arr[k] = aux[j-low];
                j++;
            }
            // 如果右半部分元素已经全部处理完毕
            else if( j > high){
                arr[k] = aux[i-low];
                i++;
            }
            // 左半部分所指元素 < 右半部分所指元素
            else if (aux[i-low] < aux[j-low]){
                arr[k] = aux[i-low];
                i++;
            }
            // 左半部分所指元素 >= 右半部分所指元素
            else {
                arr[k] = aux[j-low];
                j++;
            }
        }



    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr,0,arr.length-1);
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
