package leetcode;

import java.util.HashMap;

/**
 * leetcode 454
 */
public class FourSumII {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A==null || B==null || C==null || D==null){
            throw new IllegalArgumentException("Illegal argument");
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < D.length; j++){
                int sum = C[i]+D[j];
                if (map.containsKey(sum)){
                    map.put(sum,map.get(sum)+1);
                }
                else {
                    map.put(sum,1);
                }
            }
        }
        int res = 0;
        for(int i = 0 ; i < A.length ; i ++)
            for(int j = 0 ; j < B.length ; j ++)
                if(map.containsKey(-A[i]-B[j]))
                    res += map.get(-A[i]-B[j]);

        return res;
    }
}
