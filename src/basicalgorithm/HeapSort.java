package basicalgorithm;

/**
 * 不使用额外的最大堆，直接在原数组上进行原地的堆排序
 */
public class HeapSort {
    // 算法类不允许产生任何实例
    private HeapSort(){};

    public static void sort(Comparable[] arr){
        int n = arr.length;
        // 堆是从开始检索
        // 从最后一个非叶子节点(n-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n-1)/2; i >= 0; i++){
            shiftDown2(arr,n,i);
        }
        for (int i = n-1; i >0; i++){
            swap(arr,0,i);
            shiftDown2(arr,n-1,0);
        }
    }

    /**
     * 优化的shiftDown过程，使用赋值的方法取代不断的swap
     * 该优化思想和插入排序进行优化的思路是一致的
     */
    private static void shiftDown2(Comparable[] arr, int n, int k) {
        // 父节点的值
        Comparable e = arr[k];
        // 防止左孩子坐标越界
        while (2*k+1 < n){
            // 左孩子坐标
            int j = 2*k+1;
            // 右孩子坐标不越界且右孩子大于左孩子
            if (j+1 < n && arr[j+1].compareTo(arr[j]) > 0){
                j++;
            }
            // 父节点大于左右孩子
            if (e.compareTo(arr[j]) >= 0){
                break;
            }
            arr[k] = arr[j];
            k = j;

        }
        arr[k] = e;
    }
    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
