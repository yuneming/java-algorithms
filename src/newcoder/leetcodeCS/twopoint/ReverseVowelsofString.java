package newcoder.leetcodeCS.twopoint;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowelsofString {
    public final static HashSet<Character> vowels = new HashSet<>
            (Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
        char[] result = new char[s.length()];
        while (left <= right) {
            char cleft = s.charAt(left);
            char cright = s.charAt(right);
            if (!vowels.contains(cleft)) {
                result[left++] = cleft;
            }else if (!vowels.contains(cright)) {
                result[right--] = cright;
            } else {
                result[left++] = cleft;
                result[right--] = cright;
            }
        }
        return new String(result);

    }
}
