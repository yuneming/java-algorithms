package basicalgorithm;

public class BinarySearch {
    // 数组元素有序排列
    public static int binarySearch(int[] array,int key){
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            // 防止整型溢出
            int mid = left+(right-left)/2;
            if(array[mid]==key){
                return mid;
            }
            if(array[mid]<key){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;

    }
    public static void main(String[] args){
        int[] testArray={0,1,4,6,8,9,13,34,45,56,67,89,90,109};
        int key = 90;
        System.out.println(binarySearch(testArray,key));
    }
}
