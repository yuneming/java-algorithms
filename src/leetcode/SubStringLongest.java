package leetcode;

/**
 * leetcode 3 没有重复的字母的最长子串
 */
public class SubStringLongest {
    public static int lengthOfLongestSubstring(String s) {
        // ascii码能表示256个字符
        int[] freq = new int[256];
        // 滑动窗口为s[l,...,r]
        int l = 0,r = -1;
        int res = 0;
        while (l < s.length()){
            if (r+1 < s.length() && freq[s.charAt(r+1)] == 0){
                freq[s.charAt(++r)]++;
            }
            else {
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
    public static void main(String[] args){
        String s = "pwwkew";
        int b = lengthOfLongestSubstring(s);
        System.out.println(b);
    }
}
