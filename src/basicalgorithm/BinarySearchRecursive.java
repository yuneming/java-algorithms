package basicalgorithm;

/**
 * 递归的二分查找算法
 */
public class BinarySearchRecursive {
    // 数组元素有序排列
    public static int binarySearch(int[] array,int l, int r,int key){
        if (l > r){
            return -1;
        }
        int mid = l+(r-l)/2;
        if (array[mid] == key){
            return mid;
        }
        else if (array[mid] > key){
            return binarySearch(array,l,mid-1,key);
        }
        else {
            return binarySearch(array,mid+1,r,key);
        }
    }
    public static void main(String[] args){
        int[] testArray={0,1,4,6,8,9,13,34,45,56,67,89,90,109};
        int key = 90;
        System.out.println(binarySearch(testArray,0,testArray.length-1,key));
    }
}
