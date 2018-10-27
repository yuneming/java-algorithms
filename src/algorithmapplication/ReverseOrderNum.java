package algorithmapplication;

/**
 * 使用归并排序的方法来求数组中的逆序对
 */
public class ReverseOrderNum {
    public static int inversionCount(int[] arr, int l, int r){
        if (l >= r){
            return 0;
        }
        // 防止溢出
        int mid = l+(r-l)/2;
        // 求出 arr[l...mid] 范围的逆序数
        int res1 = inversionCount(arr,l,mid);
        // 求出 arr[mid+1...r] 范围的逆序数
        int res2 = inversionCount(arr,mid+1,r);
        return res1+res2+merge(arr,l,mid,r);


    }
    public static int merge(int[] arr, int l, int mid, int r){
        int[] aux = new int[r-l+1];
        for (int i = l; i <= r; i++){
            aux[i-l] = arr[i];
        }
        int res = 0;
        int j = l, k = mid+1;
        for( int i = l ; i <= r ; i ++ ){
            if( j > mid ){ // 如果左半部分元素已经全部处理完毕
                arr[i] = aux[k-l];
                k ++;
            }
            else if( k > r ){ // 如果右半部分元素已经全部处理完毕
                arr[i] = aux[j-l];
                j ++;
            }
            else if( aux[j-l] <= aux[k-l] ){ // 左半部分所指元素 <= 右半部分所指元素
                arr[i] = aux[j-l];
                j ++;
            }
            else{ // 右半部分所指元素 < 左半部分所指元素
                arr[i] = aux[k-l];
                k ++;
                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - j + 1
                res += (mid - j + 1);
            }
        }
        return res;

    }
    public static void main(String[] args){
        int[] testArray = new int[]{6,5,4,3};
        System.out.println(inversionCount(testArray,0,testArray.length-1));
    }
}
