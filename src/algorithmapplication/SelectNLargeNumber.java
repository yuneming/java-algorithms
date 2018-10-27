package algorithmapplication;

/**
 * 取数组中第n大的元素,使用快速排序
 */
public class SelectNLargeNumber {

    public static int patition(int[] arr, int l, int r){
        int pivot = arr[l];
        int j = l;//[l+1...j] < p ; [j+1..i) > p
        for(int i = l+1; i <= r;i++){
            if(arr[i] < pivot){
                swap(arr,i,++j);
            }
        }
        swap(arr,l,j);
        return j;
    }
    public static int selectNLargeNum(int[] arr, int l, int r, int k){
        if (l == r){
            return arr[l];
        }
        int  p = patition(arr,l,r);
        if (k == p){
            return arr[p];
        }
        else if(k < p){
            return selectNLargeNum(arr,l,p-1,k);
        }
        else {
            return selectNLargeNum(arr,p+1,r,k);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args){
        int[] testArr = new int[]{78,2,19,10,12,6,7,8,9};
        System.out.println(selectNLargeNum(testArr,0,8,6));
    }

}
