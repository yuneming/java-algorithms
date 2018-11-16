package leetcode;

/**
 * leetcode 76
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int[] hash = new int[256];
        int left = 0,right = 0,count = t.length(), minLen = Integer.MAX_VALUE;
        String result = "";
        for (char tc : t.toCharArray()) hash[tc]++;
        char[] sc = s.toCharArray();
        while (right < s.length() || count==0){
            if (count == 0){
                if (right-left<minLen){
                    minLen = right - left ;
                    result = s.substring(left,right);
                }
                if (hash[sc[left++]]++>=0) {
                    count++;
                }

            }
            else {
                if (hash[sc[right++]]-- >=1){
                    count--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String b = minWindow(s,t);
        System.out.println(b);
    }
}
