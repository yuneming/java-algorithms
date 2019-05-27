package newcoder.offer;

public class FindDuplicate3one {
    public boolean duplicate(int[] numbers, int length, int[] duplication){
        if (numbers == null || length <= 0) {
            return false;
        }
       for (int i = 0; i < length; i++) {
           while (numbers[i] != i){
               if(numbers[i]==numbers[numbers[i]]){
                   duplication[0] = numbers[i];
                   return true;
               }
               swap(numbers,numbers[i],i);
           }
       }
       return false;


    }
    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
