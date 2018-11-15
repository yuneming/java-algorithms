package leetcode;

/**
 * leetcode 344
 */
public class ReverseString {
    /**
     * 利用对撞指针实现字符串翻转
     */
    public static String reverseString(String s){
        int left = 0,right = s.length()-1;
        char[] ch = new char[s.length()];
        while (left <= right){
            ch[right]= s.charAt(left);
            ch[left] = s.charAt(right);
            left++;
            right--;
        }
        return new String(ch);
    }
    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        String s1 = reverseString(s);
        System.out.println(s1);
    }
}
