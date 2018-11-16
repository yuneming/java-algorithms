package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 438
 */
public class FindAnagrams {
    /**
     * 使用滑动窗口和hash来实现连续子串的查找
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        // 用于存放字符串p字符的个数
        int[] hash = new int[256];
        // 滑动窗口的左边界
        int left = 0;
        // 右边界
        int right = 0;
        char[] schar = s.toCharArray();
        //字符串p中需要匹配的字符个数
        int count = p.toCharArray().length;
        //统计字符串p中的字符个数
        for (char c:p.toCharArray()){
            hash[c]++;
        }
        while (right < schar.length){
            char c = schar[right++];
            //右边界上的字符c在P中
            if (hash[c]-->=1){
                //需要匹配的字符减1
                count--;
            }

            //如果左右边界之差大于p的长度
            while (right - left > p.toCharArray().length) {
                //滑动窗口左边界需右移
                char prev = schar[left++];
                //如果在滑动窗口范围外出现过一次,需要匹配的字符个数加1
                if (hash[prev]++ >= 0) {
                    count++;
                }
            }
            //如果需要匹配的字符为0,说明s中有与p匹配的字符串,返回左边界即可
            if (count == 0) {
                res.add(left);
            }

        }
        return res;
    }
    public static List<Integer> findAnagramsII(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if(s == null || p == null) {
            return result;
        }
        int left = 0,right =0,count = p.length();
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        for (char c : p.toCharArray()){
            map[c] ++;
        }
        while (right < s.length()) {
            if (map[sc[right++]]-->=1) {
                count --;
            }
            if (count == 0) {
                result.add(left);
            }
            if (right - left == p.length() && map[sc[left++]]++ >=0){
                count++;
            }
        }
        return result;

    }
    public static void main(String[] args){
        String s = "cbaebabacd";
        String t = "abc";
        List<Integer> b = findAnagramsII(s,t);
        System.out.println(b);
    }
}
