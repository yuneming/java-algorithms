package leetcode;

import java.util.TreeMap;

/**
 * leetcode 205
 */
public class IsomorphicString {
    /**
     * 利用Map的key和value来保存映射信息
     */
    public static boolean isIsomorphic(String s, String t) {
        TreeMap<Character,Character> maps = new TreeMap<>();
        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++){
            if (!maps.containsKey(s.charAt(i))){
                if (maps.containsValue(t.charAt(i))){
                    return false;
                }
                maps.put(s.charAt(i),t.charAt(i));
            }else {
                if (maps.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s = "ab",t = "aa";
        System.out.println(isIsomorphic(s,t));
    }
}
