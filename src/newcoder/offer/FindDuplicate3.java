package newcoder.offer;

import java.util.HashMap;
import java.util.HashSet;

public class FindDuplicate3 {

    /**
     * hashset存储访问过的变量
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int[] numbers, int length, int[] duplication){
        if (numbers == null || length <= 0) {
            return false;
        }
        HashSet<Integer> result = new HashSet<Integer>(length);
        for (int i = 0; i < length; i++) {
            if (result.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }
            result.add(numbers[i]);
        }
        return false;

    }



}
