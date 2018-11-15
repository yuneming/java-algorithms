package leetcode;

/**
 * leetcode 125
 */
public class ValidPalindrome {
    /**
     * 利用对撞指针判断一个字符串是不是回文串
     */
    public static boolean isPalindrome(String s){
        int left = 0,right = s.length()-1;
        while (left <= right){
            char chleft =  s.charAt(left),chRight = s.charAt(right);
            if (isChar(chleft) && isChar(chRight)){
                if (chleft>='A' && chleft<='Z'){
                    chleft +=32;
                }
                if (chRight>='A' && chRight<='Z'){
                    chRight +=32;
                }
                if (chleft != chRight){
                    return false;
                }
                else {
                    left++;
                    right--;
                }
            }
            else if(!isChar(chleft)){
                left++;
            }
            else if (!isChar(chRight)){
                right--;
            }
            else {
                left++;
                right--;
            }
        }
        return true;

    }
    public static boolean isChar(char c){
        if(c >='0' && c <='9' || c>='a' && c<='z' || c>='A'&&c<='Z'){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        String s = "race a car";
        boolean b = isPalindrome(s);
        System.out.println(b);
    }
}
