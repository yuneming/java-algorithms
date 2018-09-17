package basicalgorithm;


/**
 * @author Yune
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        for(int end = arr.length-1;end>0;end--){
            for(int i = 0; i < end; i++){
                if(arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
    public static void main(String[] args){
        int[] array={1,2,5,7,3,10,13,22,45,34};
        bubbleSort(array);
        for (int i:array
                ) {
            System.out.println(i);
        }
    }

}
