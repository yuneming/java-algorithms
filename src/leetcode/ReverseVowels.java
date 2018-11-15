package leetcode;

/**
 * leetcode 345
 */
public class ReverseVowels {
    /**
     * 利用对撞指针实现原音字母翻转
     */
    public static String reverseVowel(String s){
        int left = 0,right = s.length()-1;
        char[] ch = new char[s.length()];
        while (left <= right){
            if (isVowel(s.charAt(left)) && isVowel(s.charAt(right))){
                ch[right]= s.charAt(left);
                ch[left] = s.charAt(right);
                left++;
                right--;
            }
            else if(isVowel(s.charAt(left))){
                ch[right] = s.charAt(right);
                right--;
            }
            else if (isVowel(s.charAt(right))){
                ch[left] = s.charAt(left);
                left++;
            }
            else {
                ch[right]= s.charAt(right);
                ch[left] = s.charAt(left);
                left++;
                right--;
            }

        }
        return new String(ch);
    }
    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    public static void main(String[] args){
        String s = "leetcode";
        String s1 = reverseVowel(s);
        System.out.println(s1);
    }
}
